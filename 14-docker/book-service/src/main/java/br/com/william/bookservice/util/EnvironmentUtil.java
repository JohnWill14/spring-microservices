package br.com.william.bookservice.util;

import lombok.RequiredArgsConstructor;
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
