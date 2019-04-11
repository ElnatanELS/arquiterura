package br.ude.unifacisa.valePresente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ValePresenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValePresenteApplication.class, args);
	}

}
