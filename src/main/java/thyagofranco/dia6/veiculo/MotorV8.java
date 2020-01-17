package thyagofranco.dia6.veiculo;

import java.math.BigDecimal;

public class MotorV8 implements Motor {

	@Override
	public void ligar() {
		System.out.println("Ligando motor v8 com " + getPotencia() + " de pot�ncia");
		
	}

	@Override
	public void desligar() {
		System.out.println("Desligando motor el�trico");
		
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal("400.00");
	}

}
