package br.com.william.cambioservice.endpoint;

import br.com.william.cambioservice.model.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Random;

@RestController
@RequestMapping("/cambio-service/")
public class CambioEndPoint {
    private final static Random random = new Random();

    @Autowired
    private Environment environment;

    @GetMapping("/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount") BigDecimal amount,
                            @PathVariable("from") String from,
                            @PathVariable("to") String to){
        return Cambio.builder()
                .id(random.nextLong())
                .from(from)
                .to(to)
                .conversionFactor(BigDecimal.ONE)
                .conversionValue(amount)
                .environment(String.format("PORT %s", getLocalSeverPort()))
                .build();
    }

    private String getLocalSeverPort(){
        return environment.getProperty("local.server.port");
    }
}
