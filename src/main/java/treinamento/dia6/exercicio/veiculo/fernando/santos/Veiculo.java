package treinamento.dia6.exercicio.veiculo.fernando.santos;

public class Veiculo {

	private Motor motor;

	public Veiculo() {
		this.motor = MotorFactory.getInstance();
	}

	public void ligar() {
		motor.ligar();
		System.out.println("Pot�ncia: " + motor.getPotencia() + " hp");
	}

	public void desligar() {
		motor.desligar();
	}

}
