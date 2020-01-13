package treinamento.dia6.exercicio.veiculo.fernando.santos;

import java.math.BigDecimal;

public class MotorEletrico implements Motor {

	@Override
	public void ligar() {
		System.out.println("Motor el�trico foi ligado.");
	}

	@Override
	public void desligar() {
		System.out.println("Motor el�trico foi desligado.");
	}

	@Override
	public BigDecimal getPotencia() {
		return BigDecimal.valueOf(100);
	}

}
