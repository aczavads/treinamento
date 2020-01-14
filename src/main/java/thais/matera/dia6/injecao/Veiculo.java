package thais.matera.dia6.injecao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Veiculo {
	@Autowired
	private Motor motor;
	
	public void ligar() {
		motor.ligar();
	}
	
	public void desligar() {
		System.out.println("motor desligando");
	}

}
