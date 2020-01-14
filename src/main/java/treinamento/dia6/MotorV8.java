package treinamento.dia6;

import william.silva.dia6.injeção.Motor;

public class MotorV8 implements Motor{

	@Override
	public void Ligar() {
		System.out.println("Motor Ligado e Roncando!");
		
	}

	@Override
	public void Desligar() {
		System.out.println("Motor Desligado!");
		
	}

	@Override
	public Double GetPotencia() {
		// TODO Auto-generated method stub
		return 505.7;
	}

}
