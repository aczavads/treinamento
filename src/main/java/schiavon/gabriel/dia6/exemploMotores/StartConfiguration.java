package schiavon.gabriel.dia6.exemploMotores;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:parametros.properties")
public class StartConfiguration {

	@Value("${exemplo.motor.tipo}")
	private String tipoMotor;

	@Bean
	public Motor getMotor() throws Exception {
		switch (tipoMotor) {
		case "V6":
			return new MotorV6();
		case "V8":
			return new MotorV8();
		case "ELETRICO":
			return new MotorEletrico();
		default:
			throw new Exception("Escolha um valor para o motor");
		}
	}
}
