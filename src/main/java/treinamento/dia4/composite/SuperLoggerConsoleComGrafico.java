package treinamento.dia4.composite;

import treinamento.dia3.factory2.SuperLogger;
import treinamento.dia3.factory2.SuperLoggerConsole;
import treinamento.dia3.factory2.SuperLoggerGrafico;

public class SuperLoggerConsoleComGrafico implements SuperLogger {
	private final SuperLoggerConsole loggerConsole;
	private final SuperLoggerGrafico loggerGrafico;
	
	public SuperLoggerConsoleComGrafico() {
		this.loggerConsole = new SuperLoggerConsole();
		this.loggerGrafico = new SuperLoggerGrafico();
	}
	
	public SuperLoggerConsoleComGrafico(SuperLoggerConsole loggerConsole, SuperLoggerGrafico loggerGrafico) {
		this.loggerConsole = loggerConsole;
		this.loggerGrafico = loggerGrafico;
	}
	
	@Override
	public void log(String mensagem) {
		this.loggerConsole.log(mensagem);
		this.loggerGrafico.log(mensagem);
	}

}
