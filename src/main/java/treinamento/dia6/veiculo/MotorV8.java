package treinamento.dia6.veiculo;

import java.math.BigDecimal;

public class MotorV8 implements Motor {

	@Override
	public void ligar() {
		System.out.println("ligando v8");
	}

	@Override
	public void desligar() {
		System.out.println("desligando v8");
		
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal("240.00");
	}

}
