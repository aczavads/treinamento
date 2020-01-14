package treinamento.matheusfaxina.carro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import treinamento.matheusfaxina.dia6.livro.LivroService;
import treinamento.matheusfaxina.dia6.livro.MeuLogger;

@SpringBootApplication
public class AppSpringJPAA implements CommandLineRunner {
	
	@Autowired
	private AppVeiculo veiculo;
	
	public static void main(String[] args) {
		SpringApplication.run(AppSpringJPAA.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		veiculo.criarMotor();
	}
	
	@Bean
	public MeuLogger criarMeuLogger() {
		return new MeuLogger();
	}
	
}
