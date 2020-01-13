package schiavon.gabriel.dia6.exemploMotores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Veiculo {

	@Autowired
	private Motor motor;

	public Veiculo() {
		super();
	}
	
	public void ligar() {
		if (motor != null) {
			motor.ligar();
			System.out.println(motor.getPotencia() + " cavalos de potência");
		} else {
			System.out.println("Carro sem motor");
		}
		
	}
	
	public void desligar() {
		if (motor != null) {
			motor.desligar();
		}
	}
}
