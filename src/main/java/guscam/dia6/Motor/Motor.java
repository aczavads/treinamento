package guscam.dia6.Motor;

import java.math.BigDecimal;

public interface Motor {

	static Motor createInstance(String tipoDoMotor) {
		if (tipoDoMotor.equalsIgnoreCase("elétrico")) {
			return new MotorEletrico();
		}
		if (tipoDoMotor.equalsIgnoreCase("v6")) {
			return new MotorV6();
		}
		if (tipoDoMotor.equalsIgnoreCase("v8")) {
			return new MotorV8();
		}
		return null;
	}
	
	BigDecimal ligar();	
	BigDecimal desligar();	
	BigDecimal getPotencia();	
}
