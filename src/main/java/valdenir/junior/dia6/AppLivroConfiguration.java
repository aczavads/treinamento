package valdenir.junior.dia6;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import valdenir.junior.dia6.veiculo.Motor;
import valdenir.junior.dia6.veiculo.MotorEletrico;
import valdenir.junior.dia6.veiculo.MotorV6;
import valdenir.junior.dia6.veiculo.MotorV8;

@Configuration
@PropertySource("classpath:vtj.properties")
public class AppLivroConfiguration {

	@Value("${tipo.motor}")
	private String tipoMotor;

	@Bean
	public MeuLogger criarMeuLogger() {
		return new MeuLogger();
	}

	@Bean
	public Motor criarMotor() {
		switch (tipoMotor) {
		case "eletrico":
			return new MotorEletrico();
		case "v6":
			return new MotorV6();
		case "v8":
			return new MotorV8();
		}
		return null;
	}
}
