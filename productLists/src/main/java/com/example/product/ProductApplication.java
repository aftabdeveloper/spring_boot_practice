package com.example.product;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@OpenAPIDefinition(
		info = @Info(
				title = "Product service REST api documentation",
				description = "Product service rest api",
				version = "v1",
				contact = @Contact(
						name = "Aftab",
						email = "abc@gmail.com"
				)
		)
)
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductApplication.class, args);
	}

}
