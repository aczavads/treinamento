package thyagofranco.dia6.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppLivroThyago implements CommandLineRunner {

	@Autowired
	private LivroThyagoService service;

	public static void main(String[] args) {

		SpringApplication.run(AppLivroThyago.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		service.gerarLoteDeLivros();
		service.findAll().forEach(System.out::println);

	}
	
	@Bean
	public LoggerThyago criarLoggerThyago() {
		return new LoggerThyago();
	}
	
}
