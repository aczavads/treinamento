package treinamento.dia6.exercicio.veiculo.fernando.santos;

import java.math.BigDecimal;

public class MotorV6 implements Motor {

	@Override
	public void ligar() {
		System.out.println("Motor V6 foi ligado.");
	}

	@Override
	public void desligar() {
		System.out.println("Motor V6 foi desligado.");
	}

	@Override
	public BigDecimal getPotencia() {
		return BigDecimal.valueOf(200);
	}

}
