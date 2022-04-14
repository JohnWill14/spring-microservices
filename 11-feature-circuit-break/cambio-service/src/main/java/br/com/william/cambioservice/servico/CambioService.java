package br.com.william.cambioservice.servico;

import br.com.william.cambioservice.model.Cambio;
import br.com.william.cambioservice.repository.CambioRepository;
import br.com.william.cambioservice.util.EnvironmentUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CambioService {
    private CambioRepository cambioRepository;
    private EnvironmentUtil environmentUtil;

    public List<Cambio> getAll(){
        return cambioRepository.findAll()
                .stream()
                .map(
                        e -> {
                            e.setConversionValue(BigDecimal.ONE);
                            e.setEnvironment(environmentUtil.getLocalSeverPort());
                            return e;
                        }
                ).collect(Collectors.toList());
    }

    public Cambio findCambioCalculatedByFromCurrencyAndToCurrency(BigDecimal amount, String from, String to){
        Cambio cambio = findCambioByFromCurrencyAndToCurrency(from, to);
        BigDecimal value = cambio.getConversionFactor().multiply(amount);

        cambio.setConversionValue(value);

        return cambio;
    }


    public Cambio CalculateCambioForAmount(Cambio cambio, BigDecimal amount){
        BigDecimal value = cambio.getConversionFactor().multiply(amount);

        cambio.setConversionValue(value);

        return cambio;
    }

    public Cambio findCambioByFromCurrencyAndToCurrency(String from, String to){
        Cambio cambio = cambioRepository.findByFromAndTo(from, to);
        if(cambio == null){
            throw  new RuntimeException("ERRO cambio not dound");
        }

        return cambio;
    }
}
