package treinamento.thyagofranco.dia6.veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppVeiculo implements CommandLineRunner{
	
	@Autowired
	private Veiculo veiculo;
	
	public static void main(String[] args) {
		SpringApplication.run(AppVeiculo.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		veiculo.ligar();
		veiculo.desligar();
		
	}
	
	
	

}
