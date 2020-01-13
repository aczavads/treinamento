package treinamento.diegomucheniski.dia6.veiculo;

import java.math.BigDecimal;

public class MotorV8 implements Motor {

	@Override
	public void ligar() {
		System.out.println("Motor V8 ligado - Potência: " + getPotencia());		
	}

	@Override
	public void desligar() {
		System.out.println("Motor V8 desligado!");
		
	}

	@Override
	public BigDecimal getPotencia() {		
		return new BigDecimal("10000");
	}

}
