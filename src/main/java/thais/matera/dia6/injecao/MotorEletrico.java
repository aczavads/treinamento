package thais.matera.dia6.injecao;

import java.math.BigDecimal;

public class MotorEletrico implements Motor {

	@Override
	public void ligar() {
	}

	@Override
	public void desligar() {
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal("190.00");
	}

}
