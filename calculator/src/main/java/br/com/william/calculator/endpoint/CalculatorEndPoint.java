package br.com.william.calculator.endpoint;

import br.com.william.calculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/v1/calculator")
@RequiredArgsConstructor
public class CalculatorEndPoint {
    private final CalculatorService calculatorService;

    @GetMapping("/add/{numberOne}/{numberTwo}")
    public ResponseEntity<?> add(@PathVariable Double numberOne,
                              @PathVariable Double numberTwo){
        Double value = calculatorService.add(numberOne, numberTwo);
        return ResponseEntity.ok(value);
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public ResponseEntity<?> subtraction(@PathVariable Double numberOne,
                              @PathVariable Double numberTwo){
        Double value = calculatorService.subtraction(numberOne, numberTwo);
        return ResponseEntity.ok(value);
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public ResponseEntity<?> division(@PathVariable Double numberOne,
                                      @PathVariable Double numberTwo){
        Double value = calculatorService.division(numberOne, numberTwo);
        return ResponseEntity.ok(value);
    }

    @GetMapping("/multiply/{numberOne}/{numberTwo}")
    public ResponseEntity<?> multiply(@PathVariable Double numberOne,
                                      @PathVariable Double numberTwo){
        Double value = calculatorService.multiply(numberOne, numberTwo);
        return ResponseEntity.ok(value);
    }
}
