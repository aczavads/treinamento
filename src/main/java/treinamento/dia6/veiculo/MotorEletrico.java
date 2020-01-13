package treinamento.dia6.veiculo;

import java.math.BigDecimal;

public class MotorEletrico implements Motor {

	@Override
	public void ligar() {
		System.out.println("zuuuuuummmmm....");
	}

	@Override
	public void desligar() {
		System.out.println("zuuuut.");
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal("150.00");
	}

}
