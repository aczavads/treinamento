package treinamento.guilhermeperes.dia6.injecao.veiculo;

import java.math.BigDecimal;

public class MotorV8 implements Motor {

	@Override
	public void ligar() {
		System.out.println("Ligando o motor V8");
	}

	@Override
	public void desligar() {
		System.out.println("Desligando o motor V8");
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal(2000);
	}
}
