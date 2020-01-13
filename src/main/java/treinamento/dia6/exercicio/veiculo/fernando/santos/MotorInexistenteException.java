package treinamento.dia6.exercicio.veiculo.fernando.santos;

public class MotorInexistenteException extends RuntimeException {

	private static final long serialVersionUID = 6459228213238790180L;

	@Override
	public String getMessage() {
		return "Motor não existe!";
	}

}
