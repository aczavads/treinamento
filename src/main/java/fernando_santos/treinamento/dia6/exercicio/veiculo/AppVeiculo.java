package fernando_santos.treinamento.dia6.exercicio.veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppVeiculo implements CommandLineRunner {
	
	@Autowired
	Veiculo veiculo;
	
	public static void main(String[] args) {
		SpringApplication.run(AppVeiculo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		veiculo.ligar();
		veiculo.desligar();
		
	}
	
	@Bean
	public Veiculo getVeiculo() {
		return new Veiculo(); 
	}

}
