package valdenir.junior.dia6.veiculo;

import java.math.BigDecimal;

public class MotorEletrico implements Motor {

	@Override
	public void ligar() {
		System.out.println("ligando eletrico");
	}

	@Override
	public void desligar() {
		System.out.println("desligando eletrico");
	}

	@Override
	public BigDecimal getPotencia() {
		return new BigDecimal(50);
	}

}
