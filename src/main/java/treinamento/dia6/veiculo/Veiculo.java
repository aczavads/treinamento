package treinamento.dia6.veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Veiculo {
	@Autowired
	private Motor motor;
	
	public void ligar() {
		motor.ligar();
		System.out.println(motor.getPotencia());
	}
	
	public void desligar() {
		motor.desligar();
	}

}
