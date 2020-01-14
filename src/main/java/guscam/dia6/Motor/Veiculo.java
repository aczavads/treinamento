package guscam.dia6.Motor;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

public class Veiculo {
	@Autowired
	private Motor motor;
	
	public BigDecimal ligar() {
		return motor.ligar();
	}

}
