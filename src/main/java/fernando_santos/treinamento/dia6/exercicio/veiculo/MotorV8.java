package fernando_santos.treinamento.dia6.exercicio.veiculo;

import java.math.BigDecimal;

public class MotorV8 implements Motor {

	@Override
	public void ligar() {
		System.out.println("Motor V8 foi ligado.");
	}

	@Override
	public void desligar() {
		System.out.println("Motor V6 foi desligado.");

	}

	@Override
	public BigDecimal getPotencia() {
		return BigDecimal.valueOf(300);
	}

}
