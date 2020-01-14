package william.silva.dia6.injeção;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import treinamento.dia6.MotorV8;
import william.silva.dia6.Livro.AppLivroWd;
import william.silva.dia6.Livro.MeuLogger;

@SpringBootApplication
public class AppCarro implements CommandLineRunner {
	@Autowired
	private MeuLogger logger;
	
	@Autowired
	private Veiculo carro;
	
	

	public static void main(String[] args) {
		SpringApplication.run(AppCarro.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.Log("lol começou!");

		carro.Ligar();
		
		
	}
	
	@Bean
	public MeuLogger criarMeuLogger() {
		return new MeuLogger();
	}
	

}
