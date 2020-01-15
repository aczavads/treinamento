package william.silva.dia6.injeção;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:william.properties")
public class AppLivroConfiguration {
	
	
	@Value("${william.silva.dia6.tipoMotor}")
	private String tipoCarro;
	
	@Bean
	public Motor criarMotor() {
		if (tipoCarro.equals("ELETRICO")) {
			return new MotorEletrico();
		} else if(tipoCarro.equals("V6")) {
			return new MotorV6();
		} else if (tipoCarro.equals("V8")) {
			return new MotorV8();
		} else {
			return null;
		}

	}
	
//	@Bean
//	public Motor aaaaa() {
//
//			return new MotorV8();
//
//		
//
//	}
}
