package treinamento.matheusfaxina.carro;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class MotorEletrico implements Motor {

	@Override
	public String ligar() {
		return "Ligando o motor el�trico.";
	}

	@Override
	public String desligar() {
		return "Desligando o motor el�trico.";
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal("250.0");
	}

	
	
}
