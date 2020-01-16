package fernando_santos.treinamento.dia6.exercicio.veiculo;

public class MotorInexistenteException extends RuntimeException {

	private static final long serialVersionUID = 6459228213238790180L;

	@Override
	public String getMessage() {
		return "Motor não existe!";
	}

}
