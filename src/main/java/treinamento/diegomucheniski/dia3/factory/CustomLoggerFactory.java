package treinamento.diegomucheniski.dia3.factory;

public abstract class CustomLoggerFactory {

	public static CustomLogger createInstance(String metodo) {

		if (metodo.equals("console")) {
			return new CustomLoggerConsole();
		}
		else if (metodo.equals("grafico")) {
			return new CustomLoggerGrafico();
		}
		
		return null;
		
	}
	
}
