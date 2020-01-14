package treinamento.matheusfaxina.carro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:application.properties")
@Component
public class AppVeiculo {

	@Value("${veiculo.motor}")
	private String motorDoVeiculo;

	@Bean
	public Motor criarMotor() {
		if (motorDoVeiculo.equals("v6")) {
			System.out.println("V6");
			return new MotorV6();
		}
		if (motorDoVeiculo.equals("v8")) {
			System.out.println("V8");
			return new MotorV8();
		}
		if (motorDoVeiculo.equals("elétrico")) {
			System.out.println("ELETRICO");
			return new MotorEletrico();
		}

		return null;
	}
}
