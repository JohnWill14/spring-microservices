package br.com.william.cambioservice.endpoint;

import br.com.william.cambioservice.model.Cambio;
import br.com.william.cambioservice.servico.CambioService;
import br.com.william.cambioservice.util.EnvironmentUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cambio-service")
@AllArgsConstructor
public class CambioEndPoint {
    private CambioService cambioService;
    private EnvironmentUtil environmentUtil;

    @GetMapping("/{amount}/{from}/{to}")
    public ResponseEntity<?> getCambio(@PathVariable("amount") BigDecimal amount,
                                            @PathVariable("from") String from,
                                            @PathVariable("to") String to){
        Cambio cambio = cambioService.findCambioByFromCurrencyAndToCurrency(from, to);
        cambio = cambioService.CalculateCambioForAmount(cambio, amount);
        cambio.setEnvironment(environmentUtil.getLocalSeverPort());

        return ResponseEntity.ok(cambio);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Cambio> collect = cambioService.getAll()
                .stream()
                .map(
                        e -> {
                            e.setEnvironment(environmentUtil.getLocalSeverPort());
                            return e;
                        }
                ).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }


}
