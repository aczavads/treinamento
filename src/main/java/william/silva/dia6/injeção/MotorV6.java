package william.silva.dia6.injeção;

public class MotorV6 implements Motor{

	@Override
	public void Ligar() {
		System.out.println("Motor Ligado");
		
	}

	@Override
	public void Desligar() {
		System.out.println("Motor Desligado");
		
	}

	@Override
	public Double GetPotencia() {
		// TODO Auto-generated method stub
		return 260.0;
	}

}
