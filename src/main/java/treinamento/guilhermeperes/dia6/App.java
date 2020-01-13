package treinamento.guilhermeperes.dia6;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import treinamento.guilhermeperes.dia6.livro.Livro;
import treinamento.guilhermeperes.dia6.livro.LivroService;

@SpringBootApplication
public class App implements CommandLineRunner {
	
	@Autowired
	private LivroService service;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Livro> list = new ArrayList<>();
		
		list.add(new Livro("O Hobbit"));
		list.add(new Livro("Senhor dos An�is - A Sociedade do Anel"));
		list.add(new Livro("Senhor dos An�is - As Duas Torres"));
		list.add(new Livro("Senhor dos An�is - O Retorno do Rei"));
		
		service.gerarLote(list);
		
		List<Livro> result = service.findAll();
		
		result.stream().forEach(System.out::println);
	}
}
