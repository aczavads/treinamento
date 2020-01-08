package treinamento.diegomucheniski.dia3.factory;

public class CustomLoggerConsole implements CustomLogger{

	@Override
	public void log(String texto) {
		System.out.println(texto);		
	}

}
