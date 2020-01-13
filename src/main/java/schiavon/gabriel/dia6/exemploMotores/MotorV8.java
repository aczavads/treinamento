package schiavon.gabriel.dia6.exemploMotores;

import java.math.BigDecimal;

public class MotorV8 implements Motor {

	@Override
	public void ligar() {
		System.out.println("Ligando Motor V8");
	}

	@Override
	public void desligar() {
		System.out.println("Desligando Motor V8");
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal("450.00");
	}

}
