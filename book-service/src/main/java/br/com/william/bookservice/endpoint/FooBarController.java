package br.com.william.bookservice.endpoint;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/book-service")
@AllArgsConstructor
@Log4j2
public class FooBarController {
    @GetMapping("foo-bar")
    @Retry(name = "default")
    public String fooBar(){
//       log.info("Tentando executar");
//        new RestTemplate()
//                .getForEntity("http://localhost:8765/book-service/foo-bar",
//                        String.class);

        return "foo bar :o";
    }
}
