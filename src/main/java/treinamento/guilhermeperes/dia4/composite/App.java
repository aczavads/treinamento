package treinamento.guilhermeperes.dia4.composite;

import treinamento.guilhermeperes.dia3.patterns.factory.ConsoleLogger;
import treinamento.guilhermeperes.dia3.patterns.factory.Logger;
import treinamento.guilhermeperes.dia3.patterns.factory.LoggerFactory;

public class App {
	public static void main(String[] args) {
		Logger graficoConsoleLogger = new LoggerComposite(
				LoggerFactory.createLogger(ConsoleLogger.class),
				LoggerFactory.createLogger(GraficoLogger.class)
			);
		
		Logger graficoConsoleLogger = LoggerFactory.createLogger(LoggerComConsoleEGrafico.class);
		graficoConsoleLogger.log("Guilherme");
	}
}
