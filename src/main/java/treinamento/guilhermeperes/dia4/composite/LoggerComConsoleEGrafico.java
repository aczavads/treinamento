package treinamento.guilhermeperes.dia4.composite;

import treinamento.guilhermeperes.dia3.patterns.factory.ConsoleLogger;
import treinamento.guilhermeperes.dia3.patterns.factory.Logger;

public class LoggerComConsoleEGrafico implements Logger {
	private ConsoleLogger consoleLogger;
	private GraficoLogger graficoLogger;
	
	public LoggerComConsoleEGrafico(ConsoleLogger consoleLogger, GraficoLogger graficoLogger) {
		this.consoleLogger = consoleLogger;
		this.graficoLogger = graficoLogger;
	}

	@Override
	public void log(String text) {
		this.consoleLogger.log(text);
		this.graficoLogger.log(text);
	}
}
