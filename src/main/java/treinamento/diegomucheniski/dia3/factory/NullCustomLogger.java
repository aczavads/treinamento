package treinamento.diegomucheniski.dia3.factory;

public class NullCustomLogger implements CustomLogger {

	@Override
	public void log(String texto) {
		System.out.println("N�o foi passado um parametro v�lido!");
	}

}
