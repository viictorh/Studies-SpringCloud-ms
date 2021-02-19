package br.com.vhb.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//Cria um singleton que disponibiliza a injeção de um objeto de acordo com a anotação do @Bean
//Assim, ele chamará a forma de criação do bean e disponibilizará como singleton para injeção de dependencia
@Configuration
public class AppConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
