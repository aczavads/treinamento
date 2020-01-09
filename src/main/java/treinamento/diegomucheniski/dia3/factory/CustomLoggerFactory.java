package treinamento.diegomucheniski.dia3.factory;

import treinamento.diegomucheniski.dia4.composer.CustomLoggerComsoleComGrafico;

public abstract class CustomLoggerFactory {

	public static CustomLogger createInstance(String metodo) {

		if (metodo.equals("console")) {
			return new CustomLoggerConsole();
		}
		if (metodo.equals("grafico")) {
			return new CustomLoggerGrafico();
		}
		if (metodo.equals("console-grafico")) {
			return new CustomLoggerComsoleComGrafico();
		}
		
		if (metodo.equals("console-triplo")) {
			CustomLoggerComposite composite = new CustomLoggerComposite();
			composite.addLogger(new CustomLoggerConsole());
			composite.addLogger(new CustomLoggerConsole());
			composite.addLogger(new CustomLoggerConsole());
			return composite;
		}
		
		return new NullCustomLogger();
		
	}
	
}
