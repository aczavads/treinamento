package giovani.bueno.dia4;

import giovani.bueno.factory.Console;
import giovani.bueno.factory.Grafico;
import giovani.bueno.factory.SuperLogger;

public class SuperLoggerConsoleComGrafico implements SuperLogger {
	
	private final Console loggerConsole;
	private final Grafico loggerGrafico;
	
	public SuperLoggerConsoleComGrafico() {
		this.loggerConsole = new Console();
		this.loggerGrafico = new Grafico();
	}
	
	public SuperLoggerConsoleComGrafico(Console console, Grafico grafico) {
		this.loggerConsole = console;
		this.loggerGrafico = grafico;
	}
	
	@Override
	public void log(String mensagem) {
		this.loggerConsole.log(mensagem);
		this.loggerGrafico.log(mensagem);
	}
			

}
