package br.com.william.calculator.endpoint.v2;

import br.com.william.calculator.dto.ValuesDTO;
import br.com.william.calculator.service.CalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "calculatorEndPointV2", description = "Endpoints for calculator")
@RestController(value = "calculatorEndPointV2")
@RequestMapping("/v2/calculator")
@RequiredArgsConstructor
public class CalculatorEndPoint {
    private final CalculatorService calculatorService;

    @Operation(summary = "add")
    @GetMapping(value = "/add",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
    public ResponseEntity<?> add(@RequestBody ValuesDTO valuesDTO){
        Double value = calculatorService.add(valuesDTO.getValueOne(), valuesDTO.getValueTwo());
        return ResponseEntity.ok(value);
    }

    @Operation(summary = "subtraction")
    @GetMapping(value = "/subtraction",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
    public ResponseEntity<?> subtraction(@RequestBody ValuesDTO valuesDTO){
        Double value = calculatorService.subtraction(valuesDTO.getValueOne(), valuesDTO.getValueTwo());
        return ResponseEntity.ok(value);
    }

    @Operation(summary = "division")
    @GetMapping(value = "/division",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
    public ResponseEntity<?> division(@RequestBody ValuesDTO valuesDTO){
        Double value = calculatorService.division(valuesDTO.getValueOne(), valuesDTO.getValueTwo());
        return ResponseEntity.ok(value);
    }

    @Operation(summary = "multiply")
    @GetMapping(value = "/multiply",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
    public ResponseEntity<?> multiply(@RequestBody ValuesDTO valuesDTO){
        Double value = calculatorService.multiply(valuesDTO.getValueOne(), valuesDTO.getValueTwo());
        return ResponseEntity.ok(value);
    }
}
