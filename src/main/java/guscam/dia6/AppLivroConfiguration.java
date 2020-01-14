package guscam.dia6;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import guscam.dia6.Motor.Motor;

@Configuration
@PropertySource("classpath:motor.properties")
public class AppLivroConfiguration {
	@Value("${tipoDoMotor}")
	private String tipoDoMotor;

	@Bean
	public Motor criarMotor() {
		return Motor.createInstance(tipoDoMotor);
	}

}
