package thais.matera.dia6.injecao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:veiculo.properties")
public class AppConfiguration {
	@Value("${tipo.do.motor}")
	private String motorTipo;
	
	@Bean
	public Motor MotorFactory() {
		if(motorTipo.equals("v8")) {
			return new MotorV8();
		}
		
		if(motorTipo.equals("v6")) {
			return new MotorV6();
		}
		
		if(motorTipo.equals("eletrico")){
			return new MotorEletrico();
		}
		
		throw new RuntimeException("Tipo do motor inválido");
	}
}
