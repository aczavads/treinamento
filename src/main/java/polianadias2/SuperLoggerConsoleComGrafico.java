package polianadias2;

import treinamento.dia3.factory2.SuperLogger;
import treinamento.dia3.factory2.SuperLoggerConsole;
import treinamento.dia3.factory2.SuperLoggerGrafico;

public class SuperLoggerConsoleComGrafico implements SuperLogger {
	
	
	private final SuperLoggerConsole loggerConsole;
	private final SuperLoggerGrafico loggerGrafico;
	
	public SuperLoggerConsoleComGrafico(SuperLoggerConsole loggerConsole, SuperLoggerGrafico loggerGrafico) {
		this.loggerConsole = LoggerConsole;
		this.loggerGrafico = LoggerGrafico;
			}
	
	public void log(String manensagem) {
		this.loggerConsole.log(mensagem);
		this.loggerGrafico.log(mensagem);
		
	}
			

}
