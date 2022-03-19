package br.com.william.calculator.handler;

import br.com.william.calculator.handler.error.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class handlerException  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> handleAllBadRequestException(ArithmeticException arithmeticException){
        ErrorDetails exceptionSchema = ErrorDetails.builder()
                .messageException(arithmeticException.getMessage())
                .typeErro(arithmeticException.getClass().getSimpleName())
                .erroCode(HttpStatus.BAD_REQUEST)
                .timeException(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionSchema, HttpStatus.BAD_REQUEST);
    }
}
