package br.com.vhb.hruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

	/**
	 * Exemplo da utilização para criação de hash. Este método é chamado devido a
	 * implementação da interface {@link CommandLineRunner}, que executa esta função
	 * ao iniciar a aplicação
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("BCRYPT = " + passEncoder.encode("Teste123456"));

	}

}
