package treinamento.diegomucheniski.dia3.factory;

public class NullCustomLogger implements CustomLogger {

	@Override
	public void log(String texto) {
		System.out.println("Não foi passado um parametro válido!");
	}

}
