package treinamento.matheusfaxina.carro;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class MotorV8 implements Motor {

	@Override
	public String ligar() {
		return "Ligando o motor v8.";
	}

	@Override
	public String desligar() {
		return "Desligando o motor v8.";
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal("450.0");
	}

	
	
}
