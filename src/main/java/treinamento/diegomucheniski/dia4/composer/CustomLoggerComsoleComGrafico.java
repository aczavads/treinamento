package treinamento.diegomucheniski.dia4.composer;

import treinamento.diegomucheniski.dia3.factory.CustomLogger;
import treinamento.diegomucheniski.dia3.factory.CustomLoggerConsole;
import treinamento.diegomucheniski.dia3.factory.CustomLoggerGrafico;

public class CustomLoggerComsoleComGrafico implements CustomLogger {
	
	private final CustomLoggerConsole loggerConsole;
	private final CustomLoggerGrafico loggerGrafico;	

	public CustomLoggerComsoleComGrafico() {
		this.loggerConsole = new CustomLoggerConsole();
		this.loggerGrafico = new CustomLoggerGrafico();
	}
	
	public CustomLoggerComsoleComGrafico(CustomLoggerConsole loggerConsole, CustomLoggerGrafico loggerGrafico) {		
		this.loggerConsole = loggerConsole;
		this.loggerGrafico = loggerGrafico;
	}

	@Override
	public void log(String texto) {
		this.loggerConsole.log(texto);
		this.loggerGrafico.log(texto);
	}

}
