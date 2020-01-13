package schiavon.gabriel.dia6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import schiavon.gabriel.dia6.livro.LivroService;

@SpringBootApplication
public class LivroApp implements CommandLineRunner {
	
	@Autowired
	private LivroService livroService;
	
	public static void main(String[] args) {
		SpringApplication.run(LivroApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		livroService.gerarLoteLivros();
		livroService.findAll().forEach(System.out::println);	
	}

}
