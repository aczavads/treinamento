package treinamento.dia6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import treinamento.dia6.livro.LivroService;
import treinamento.dia6.veiculo.Veiculo;

@SpringBootApplication
public class App implements CommandLineRunner {
	@Autowired
	private LivroService service;
	@Autowired
	private Veiculo veiculo;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//service.gerarLoteDeLivros();
		//service.findAll().forEach(System.out::println);
		veiculo.ligar();
		veiculo.desligar();
	}
		
}







