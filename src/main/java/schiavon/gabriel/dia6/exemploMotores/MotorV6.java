package schiavon.gabriel.dia6.exemploMotores;

import java.math.BigDecimal;

public class MotorV6 implements Motor {

	@Override
	public void ligar() {
		System.out.println("Ligando Motor V6");
	}

	@Override
	public void desligar() {
		System.out.println("Desligando Motor V6");
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal("200.00");
	}

}
