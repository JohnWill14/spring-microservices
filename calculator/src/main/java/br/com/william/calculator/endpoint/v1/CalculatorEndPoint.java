package br.com.william.calculator.endpoint.v1;

import br.com.william.calculator.service.CalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Author", description = "Endpoints for calculator")
@RestController
@RequestMapping("/v1/calculator")
@RequiredArgsConstructor
public class CalculatorEndPoint {
    private final CalculatorService calculatorService;

    @Operation(summary = "add")
    @GetMapping("/add/{numberOne}/{numberTwo}")
    public ResponseEntity<?> add(@PathVariable Double numberOne,
                              @PathVariable Double numberTwo){
        Double value = calculatorService.add(numberOne, numberTwo);
        return ResponseEntity.ok(value);
    }

    @Operation(summary = "subtraction")
    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public ResponseEntity<?> subtraction(@PathVariable Double numberOne,
                              @PathVariable Double numberTwo){
        Double value = calculatorService.subtraction(numberOne, numberTwo);
        return ResponseEntity.ok(value);
    }

    @Operation(summary = "division")
    @GetMapping("/division/{numberOne}/{numberTwo}")
    public ResponseEntity<?> division(@PathVariable Double numberOne,
                                      @PathVariable Double numberTwo){
        Double value = calculatorService.division(numberOne, numberTwo);
        return ResponseEntity.ok(value);
    }

    @Operation(summary = "multiply")
    @GetMapping("/multiply/{numberOne}/{numberTwo}")
    public ResponseEntity<?> multiply(@PathVariable Double numberOne,
                                      @PathVariable Double numberTwo){
        Double value = calculatorService.multiply(numberOne, numberTwo);
        return ResponseEntity.ok(value);
    }
}
