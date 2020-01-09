package treinamento.thyagofranco.dia4.composer;

import treinamento.thyagofranco.dia3.designpatterns.factory.SuperLogger;
import treinamento.thyagofranco.dia3.designpatterns.factory.SuperLoggerConsole;
import treinamento.thyagofranco.dia3.designpatterns.factory.SuperLoggerGrafico;

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
