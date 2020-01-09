package guscam.dia4.composite;

import guscam.dia3.factory.MyLogger;
import guscam.dia3.factory.MyLoggerConsole;
import guscam.dia3.factory.MyLoggerGrafico;

public class MyLoggerConsoleGrafico implements MyLogger {
	private final MyLoggerConsole myLoggerConsole;
	private final MyLoggerGrafico myLoggerGrafico;
	
	public MyLoggerConsoleGrafico () {
		this.myLoggerConsole = new MyLoggerConsole();
		this.myLoggerGrafico = new MyLoggerGrafico();
	}

	@Override
	public void log(String message) {
		this.myLoggerConsole.log(message);
		this.myLoggerGrafico.log(message);
		
	}

}
