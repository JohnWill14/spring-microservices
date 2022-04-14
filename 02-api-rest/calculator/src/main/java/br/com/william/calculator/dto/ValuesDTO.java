package br.com.william.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ValuesDTO {
    private Double valueOne;
    private Double valueTwo;
}
