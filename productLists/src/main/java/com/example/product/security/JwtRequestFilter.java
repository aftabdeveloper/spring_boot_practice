package com.example.product.security;

import com.example.product.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService service;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         String authHeader = request.getHeader("Authorization");
         String username = null;
         String token = null;

         if(authHeader != null && authHeader.startsWith("Bearer ")){
             token = authHeader.substring(7);
             username = jwtUtil.extractUsername(token);
         }

         if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
             UserDetails user =service.loadUserByUsername(username);
             List<String> roles = jwtUtil.extractRole(token);
             List<SimpleGrantedAuthority> authorities= roles.stream().map(role -> new SimpleGrantedAuthority(role))
                     .toList();
             if (jwtUtil.validToken(token,user.getUsername())){
                 UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user,null,authorities);
                 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                 SecurityContextHolder.getContext().setAuthentication(authToken);
             }
         }
         filterChain.doFilter(request,response);
    }
}
