package treinamento.thyagofranco.dia6.veiculo;

import java.math.BigDecimal;

public class MotorV6 implements Motor{

	@Override
	public void ligar() {
		System.out.println("Ligando motor v6 com " + getPotencia() + " de potência");
		
	}

	@Override
	public void desligar() {
		System.out.println("Desligando motor V6");
		
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal("250.00");
	}

}
