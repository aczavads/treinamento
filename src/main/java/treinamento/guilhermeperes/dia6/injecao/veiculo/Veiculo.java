package treinamento.guilhermeperes.dia6.injecao.veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Veiculo {
	
	@Autowired
	private Motor motor;
	
	public void ligar() {
		motor.ligar();
		
		System.out.println("Potência do motor: " + motor.getPotencia());
	}
	
	public void desligar() {
		motor.desligar();
	}
}
