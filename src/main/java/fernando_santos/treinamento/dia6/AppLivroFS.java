package fernando_santos.treinamento.dia6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fernando_santos.treinamento.dia6.livro.LivroServiceFS;

@SpringBootApplication
public class AppLivroFS implements CommandLineRunner {

	@Autowired
	private LivroServiceFS service;
	
	public static void main(String[] args) {
		SpringApplication.run(AppLivroFS.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.gerarLoteDeLivros();
		service.findAll();
	}
	
	@Bean
	public MeuLoggerFS criarMeuLogger() {
		return new MeuLoggerFS();
	}

}
