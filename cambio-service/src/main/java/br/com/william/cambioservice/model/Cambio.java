package br.com.william.cambioservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cambio {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal conversionValue;
    private String environment;
}
