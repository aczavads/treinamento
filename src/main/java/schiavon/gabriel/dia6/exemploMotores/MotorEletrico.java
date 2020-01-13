package schiavon.gabriel.dia6.exemploMotores;

import java.math.BigDecimal;

public class MotorEletrico implements Motor {

	@Override
	public void ligar() {
		System.out.println("Ligando Motor Elétrico");
	}

	@Override
	public void desligar() {
		System.out.println("Desligando Motor Elétrico");
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal("150.00");
	}

}
