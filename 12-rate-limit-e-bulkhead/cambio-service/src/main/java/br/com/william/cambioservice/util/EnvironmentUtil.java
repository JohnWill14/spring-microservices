package br.com.william.cambioservice.util;

import br.com.william.cambioservice.servico.CambioService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnvironmentUtil {
    private final Environment environment;
    public String getLocalSeverPort(){
        return environment.getProperty("local.server.port");
    }
}
