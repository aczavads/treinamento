package treinamento.diegomucheniski.dia6.veiculo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mucheniski.properties")
public class AppVeiculoConfiguration {
	
	@Value("${meu-tipo-motor}")
	private String meuTipoMotor;
	
	@Bean
	public Motor getMotor() {		
		if (meuTipoMotor.equals("ELETRICO")) {
			return new MotorEletrico();
		}	
		if (meuTipoMotor.equals("V8")) {
			return new MotorV8();
		}
		throw new RuntimeException("Um tipo de motor deve ser instanciado!");	
	}


}
