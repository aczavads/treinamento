package treinamento.diegomucheniski.dia6.veiculo;

import java.math.BigDecimal;

public class MotorEletrico implements Motor {

	@Override
	public void ligar() {
		System.out.println("Motor Elétrico ligado - Potência: " + getPotencia());		
	}

	@Override
	public void desligar() {
		System.out.println("Motor Elétrico desligado!");
		
	}

	@Override
	public BigDecimal getPotencia() {		
		return new BigDecimal("1000");
	}

}
