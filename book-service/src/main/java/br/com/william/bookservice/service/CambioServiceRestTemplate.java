package br.com.william.bookservice.service;

import br.com.william.bookservice.response.Cambio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CambioServiceRestTemplate {
    private final String URL = "http://localhost:8000/cambio-service/{amount}/{from}/{to}";
    public Cambio getCambio(BigDecimal amount, String from, String to){
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();
        params.put("amount", amount.toString());
        params.put("from",from);
        params.put("to",to);

        ResponseEntity<Cambio> responseEntity = restTemplate.getForEntity(URL, Cambio.class, params);

        return responseEntity.getBody();
    }
}
