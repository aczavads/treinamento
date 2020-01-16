package fernando_santos.treinamento.dia4.composite;

import java.util.logging.Level;

import fernando_santos.treinamento.dia3.factory.LoggerConsole;
import fernando_santos.treinamento.dia3.factory.LoggerGrafico;
import fernando_santos.treinamento.dia3.factory.SuperLogger;

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
