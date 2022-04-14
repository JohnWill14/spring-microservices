package br.com.william.greeting.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("greeting-service") // faz a passagem do YAML para os valores de uma Classe
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GreetingConfiguration {
    private String greeting;
    private String defaultValue;
}
