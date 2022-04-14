package br.com.william.testeambiente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@SpringBootApplication
@RestController
public class TesteAmbienteApplication {

	@GetMapping("/hello")
	public ResponseEntity<?> hello() {
		return ResponseEntity.ok("hello World !!!");
	} 
	
	@GetMapping("/hello/{name}")
	public ResponseEntity<?> hello(@PathVariable("name") String name) {
		return ResponseEntity.ok(String.format("hello %s !!!", name));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TesteAmbienteApplication.class, args);
	}

}
