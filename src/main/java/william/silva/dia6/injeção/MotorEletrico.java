package william.silva.dia6.inje��o;

public class MotorEletrico implements Motor{

	@Override
	public void Ligar() {
		System.out.println("Motor El�trico Pronto");
		
	}

	@Override
	public void Desligar() {
		System.out.println("Motor El�trico Intertravado");
		
	}

	@Override
	public Double GetPotencia() {
		return 650.0;
	}



}
