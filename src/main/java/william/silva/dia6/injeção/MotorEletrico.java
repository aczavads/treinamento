package william.silva.dia6.injeção;

public class MotorEletrico implements Motor{

	@Override
	public void Ligar() {
		System.out.println("Motor Elétrico Pronto");
		
	}

	@Override
	public void Desligar() {
		System.out.println("Motor Elétrico Intertravado");
		
	}

	@Override
	public Double GetPotencia() {
		return 650.0;
	}



}
