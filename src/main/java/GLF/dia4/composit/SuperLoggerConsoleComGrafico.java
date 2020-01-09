package GLF.dia4.composit;

import GLF.dia3.factory2.SuperLogger;
import GLF.dia3.factory2.SuperLoggerConsole;
import GLF.dia3.factory2.SuperLoggerGrafico;

public class SuperLoggerConsoleComGrafico implements SuperLogger{
	
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
