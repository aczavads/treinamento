package treinamento.guilhermeperes.dia6.injecao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import treinamento.guilhermeperes.dia6.injecao.veiculo.Motor;

@Configuration
public class AppConfig {
	
	@Value("${tipo.do.motor}")
	private String tipoMotor;
	
	@Bean
	public Motor criarMotor() {
		try {
			return (Motor) Class.forName(tipoMotor)
					.getDeclaredConstructor()
					.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Motor Inválido.");
		}
	}
}
