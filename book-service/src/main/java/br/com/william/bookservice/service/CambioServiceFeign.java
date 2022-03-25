package br.com.william.bookservice.service;

import br.com.william.bookservice.response.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@Service
@FeignClient(value = "cambio-service", url = "http://localhost:8000/cambio-service")
public interface CambioServiceFeign {

    @GetMapping("/{amount}/{from}/{to}")
    Cambio getCambio(@PathVariable("amount") BigDecimal amount,
                     @PathVariable("from") String from,
                     @PathVariable("to") String to);
}
