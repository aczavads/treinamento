package valdenir.junior.dia6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import valdenir.junior.dia6.livro.LivroTJService;
import valdenir.junior.dia6.veiculo.Veiculo;

@SpringBootApplication
public class AppLivro implements CommandLineRunner {

	@Autowired
	private LivroTJService service;
	@Autowired
	private Veiculo veiculo;

	public static void main(String[] args) {
		SpringApplication.run(AppLivro.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		veiculo.ligar();
		veiculo.desligar();
//		service.findAll().forEach(System.out::println);
	}
}
