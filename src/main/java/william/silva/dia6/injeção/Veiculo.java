package william.silva.dia6.injeção;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Veiculo {
	@Autowired
	private Motor motor;
	
	public void Ligar() {
		motor.Ligar();
		
	}

	public void Desligar() {
		motor.Desligar();
	}
}
