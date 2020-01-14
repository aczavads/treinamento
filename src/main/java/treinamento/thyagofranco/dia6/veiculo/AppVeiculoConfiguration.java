package treinamento.thyagofranco.dia6.veiculo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:veiculo.properties")
public class AppVeiculoConfiguration {
	
	@Value("${meu-tipo-motor}")
	private String meuTipoMotorString;
	
	@Bean
	public Motor criarMotor() {
		if(meuTipoMotorString.equals("ELETRICO")) {
			return new MotorEletrico();
		}
		if(meuTipoMotorString.equals("V6")) {
			return new MotorEletrico();
		}
		if(meuTipoMotorString.equals("V8")) {
			return new MotorV8();
		}
		
		throw new RuntimeException("Um tipo de motor deve ser selecionado");
	} 
	


}
