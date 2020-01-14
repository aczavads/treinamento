package treinamento.thyagofranco.dia6.veiculo;

import java.math.BigDecimal;

public class MotorEletrico implements Motor {

	@Override
	public void ligar() {
		System.out.println("Ligando motor el�trico com " + getPotencia() + " de pot�ncia");
	}

	@Override
	public void desligar() {
		System.out.println("Desligando motor el�trico");
		
	}

	@Override
	public BigDecimal getPotencia() {
		
		return new BigDecimal("100.00");
	}
	
}
