package br.ude.unifacisa.promocao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PromocaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromocaoApplication.class, args);
	}

}
