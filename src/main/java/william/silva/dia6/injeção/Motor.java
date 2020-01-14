package william.silva.dia6.injeção;

import org.springframework.stereotype.Component;


public interface Motor {
	public void Ligar();
	public void Desligar();
	public Double GetPotencia();
}
