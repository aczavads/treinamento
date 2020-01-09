package guscam.dia3.factory;

import guscam.dia4.composite.MyLoggerConsoleGrafico;

public interface MyLoggerFactory {

	static MyLogger createInstance(String tipoDoLog) {
		if (tipoDoLog.equalsIgnoreCase("console")) {
			return new MyLoggerConsole();
		}
		if (tipoDoLog.equalsIgnoreCase("grafico")) {
			return new MyLoggerGrafico();
		}
		if (tipoDoLog.equalsIgnoreCase("console-grafico")) {
			return new MyLoggerConsoleGrafico();
		}
		return null;
	}

}
