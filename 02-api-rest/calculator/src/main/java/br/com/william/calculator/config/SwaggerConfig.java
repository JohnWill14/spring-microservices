package br.com.william.calculator.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Calculator API",
        version = "1.0",
        description = "api rest que simula uma calculadora simples",
        contact = @Contact(name = "John William", email = "johnwill.v.2017@gmail.com")
))
public class SwaggerConfig {
}
