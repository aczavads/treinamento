package thais.matera.dia6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import thais.matera.dia6.livro.LivroService;

@SpringBootApplication
public class AppLivro implements CommandLineRunner {
	@Autowired
	private LivroService service;
	
	public static void main(String[] args) {
		SpringApplication.run(AppLivro.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		service.gerarLoteDeLivros();
		service.findAll().forEach(System.out::println);
	}

	@Bean
	public MyLogger criarMyLogger() {
		return new MyLogger();
	}
}
