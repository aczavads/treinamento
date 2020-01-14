package thais.matera.dia6.injecao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
	@Autowired
	private Veiculo veiculo;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	public void run(String...args) throws Exception {
		veiculo.ligar();
		veiculo.desligar();
	}
	
}
