package treinamento.diegomucheniski.dia3.factory;

import treinamento.diegomucheniski.dia4.composer.CustomLoggerComsoleComGrafico;

public abstract class CustomLoggerFactory {

	public static CustomLogger createInstance(String tipo) {

		if (tipo.equals("console")) {
			return new CustomLoggerConsole();
		}
		if (tipo.equals("grafico")) {
			return new CustomLoggerGrafico();
		}
		if (tipo.equals("console-grafico")) {
			return new CustomLoggerComsoleComGrafico();
		}
		
		if (tipo.equals("console-triplo")) {
			CustomLoggerComposite composite = new CustomLoggerComposite();
			composite.addLogger(new CustomLoggerConsole());
			composite.addLogger(new CustomLoggerConsole());
			composite.addLogger(new CustomLoggerConsole());
			return composite;
		}
		
		return new NullCustomLogger();
		
	}
	
}
