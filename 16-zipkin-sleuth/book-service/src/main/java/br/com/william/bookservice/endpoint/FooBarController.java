package br.com.william.bookservice.endpoint;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Tag(name = "foo bar endpoint")
@RestController
@RequestMapping("/book-service")
@AllArgsConstructor
@Log4j2
public class FooBarController {

    @Operation(summary = "teste com circuit breaker")
    @GetMapping("foo-bar")
//    @Retry(name = "default", fallbackMethod = "fallbackMethod")
//    @CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
    @Bulkhead(name = "default")
    public String fooBar(){
//       log.info("Tentando executar");
//        new RestTemplate()
//                .getForEntity("http://localhost:8765/book-service/foo-ba",
//                        String.class);

        return "foo bar :o";
    }

    public String fallbackMethod(Exception ex){
        return "outra mensagem foo-bar";
    }
}
