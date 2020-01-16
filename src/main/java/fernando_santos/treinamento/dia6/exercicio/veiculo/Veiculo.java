package fernando_santos.treinamento.dia6.exercicio.veiculo;

public class Veiculo {

	private Motor motor;

	public Veiculo() {
		this.motor = MotorFactory.getInstance();
	}

	public void ligar() {
		motor.ligar();
		System.out.println("Potência: " + motor.getPotencia() + " hp");
	}

	public void desligar() {
		motor.desligar();
	}

}
