package treinamento.guilhermeperes.dia6.injecao.veiculo;

import java.math.BigDecimal;

public class MotorEletrico implements Motor {

	@Override
	public void ligar() {
		System.out.println("Ligando o motor el�trico");
	}

	@Override
	public void desligar() {
		System.out.println("Desligando o motor el�trico");
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal(100);
	}
}
