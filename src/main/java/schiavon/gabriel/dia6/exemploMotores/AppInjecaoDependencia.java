package schiavon.gabriel.dia6.exemploMotores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppInjecaoDependencia implements CommandLineRunner {

	@Autowired
	private Veiculo veiculo;

	public static void main(String[] args) {
		SpringApplication.run(AppInjecaoDependencia.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		veiculo.ligar();
		veiculo.desligar();
	}

}
