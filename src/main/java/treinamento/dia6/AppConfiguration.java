package treinamento.dia6;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import treinamento.dia6.veiculo.Motor;
import treinamento.dia6.veiculo.MotorEletrico;
import treinamento.dia6.veiculo.MotorV6;
import treinamento.dia6.veiculo.MotorV8;

@Configuration
@PropertySource("classpath:veiculo.properties")
public class AppConfiguration {
	@Value("${tipo.do.motor}")
	private String tipoDoMotor;
	
	@Bean
	public Motor criarMotor() {
		if (tipoDoMotor.equals("v6")) {
			return new MotorV6();
		}
		if (tipoDoMotor.equals("v8")) {
			return new MotorV8();
		}
		if (tipoDoMotor.equals("elétrico")) {
			return new MotorEletrico();
		}
		throw new RuntimeException("Um tipo de motor deve ser selecionado!");
	}
	
	@Bean
	public MeuLogger criarMeuLogger() {
		return new MeuLogger();
	}
}
