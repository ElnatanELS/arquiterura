package br.ude.unifacisa.Autor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutorApplication.class, args);
	}

}
