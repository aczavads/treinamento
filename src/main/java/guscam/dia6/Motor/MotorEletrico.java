package guscam.dia6.Motor;

import java.math.BigDecimal;

public class MotorEletrico implements Motor {

	@Override
	public BigDecimal ligar() {
		return new BigDecimal("123.45");
	}

	@Override
	public BigDecimal desligar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getPotencia() {
		// TODO Auto-generated method stub
		return null;
	}

}
