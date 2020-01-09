package treinamento.dia4.fernando.santos.composite;

import java.util.logging.Level;

import treinamento.dia3.fernando.santos.factory.LoggerConsole;
import treinamento.dia3.fernando.santos.factory.LoggerGrafico;
import treinamento.dia3.fernando.santos.factory.SuperLogger;

public class SuperLoggerConsoleComGrafico implements SuperLogger {
	
	private final LoggerConsole loggerConsole;
	private final LoggerGrafico loggerGrafico;
	
//	public SuperLoggerConsoleComGrafico(LoggerConsole loggerConsole, LoggerGrafico loggerGrafico) {
//		this.loggerConsole = loggerConsole;
//		this.loggerGrafico = loggerGrafico;
//	}
	
	public SuperLoggerConsoleComGrafico() {
		this.loggerConsole = new LoggerConsole();
		this.loggerGrafico = new LoggerGrafico();
	}

	@Override
	public void log(Level level, String mensagem) {
		this.loggerConsole.log(level, mensagem);
		this.loggerGrafico.log(level, mensagem);
	}
	
	

}
