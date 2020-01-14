package valdenir.junior.dia6.veiculo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public interface Motor {
	public void ligar();

	public void desligar();

	public BigDecimal getPotencia();
}
