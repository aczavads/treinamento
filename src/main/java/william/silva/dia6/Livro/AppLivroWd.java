package william.silva.dia6.Livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppLivroWd implements CommandLineRunner {
	@Autowired
	private LivroServiceWd serviceWd;
	
	@Autowired
	private MeuLogger logger;

	public static void main(String[] args) {
		SpringApplication.run(AppLivroWd.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.Log("lol começou!");
		serviceWd.gerarLoteDeLivros();
		serviceWd.findAll().forEach(System.out::println);
		
	}
	
	@Bean
	public MeuLogger criarMeuLogger() {
		return new MeuLogger();
	}
	
}
