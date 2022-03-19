package br.com.william.calculator.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CalculatorService {

    public Double add(Double a, Double b){
        return a + b;
    }

    public Double subtraction(Double a, Double b){
        return a - b;
    }

    public Double division(Double a, Double b){
        if(b==0){
            throw new ArithmeticException("division by zero");
        }
        return a / b;
    }

    public Double multiply(Double a, Double b){
        if(b==0){
            throw new ArithmeticException("division by zero");
        }
        return a / b;
    }

}
