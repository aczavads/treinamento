package thais.matera.dia6.injecao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App implements CommandLineRunner {
	@Autowired
	private Veiculo veiculo;
	
	@Value("${motor.tipo}")
	private String motorTipo;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
	
	public void run(String...args) {
		System.out.println(motorTipo);
		veiculo.ligar();
		veiculo.desligar();
	}
	
	@Bean
	public Motor motorFactory() {
		Motor motor;
		
//		if(motorTipo.equals("motor-v8")) {
//			motor = new MotorV8();
//		}else if(motorTipo.equals("motor-v6")) {
//			motor = new MotorV6();
//		}else {
			motor = new MotorEletrico();
//		}
	
		return motor;
	}
	
}
