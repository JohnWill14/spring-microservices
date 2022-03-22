package br.com.william.greeting.endpoint;

import br.com.william.greeting.configuration.GreetingConfiguration;
import br.com.william.greeting.model.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetings")
@RequiredArgsConstructor
public class GreetingEndPoint {
    private final static AtomicLong countAtomic;
    private final String templatGreeting = "%s, %s";
    private final GreetingConfiguration greetingConfiguration;

    static{
        countAtomic = new AtomicLong(0L);
    }

    @GetMapping()
    public ResponseEntity<?> greeting(@RequestParam(defaultValue = "") String name){
        if(name.isEmpty()){
            name = greetingConfiguration.getDefaultValue();
        }

        Greeting greeting = Greeting.builder()
                .id(countAtomic.incrementAndGet())
                .greeting(String.format(templatGreeting, greetingConfiguration.getGreeting(), name))
                .build();

        return ResponseEntity.ok(greeting);
    }
}
