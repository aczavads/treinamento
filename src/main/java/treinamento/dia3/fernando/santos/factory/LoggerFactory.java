package treinamento.dia3.fernando.santos.factory;

import treinamento.dia4.fernando.santos.composite.NullSuperLogger;
import treinamento.dia4.fernando.santos.composite.SuperLoggerComposite;
import treinamento.dia4.fernando.santos.composite.SuperLoggerConsoleComGrafico;

public interface LoggerFactory {

	static SuperLogger createInstance(String logger) {
		if (logger.equals("console")) {
			return new LoggerConsole();
		}
		if (logger.equals("grafico")) {
			return new LoggerGrafico();
		}
		if (logger.equals("console-com-grafico")) {
			return new SuperLoggerConsoleComGrafico();
		}
		if (logger.equals("console-triplo")) {
			SuperLoggerComposite superLoggerComposite = new SuperLoggerComposite(new LoggerConsole(),
					new LoggerConsole(), new LoggerConsole());
			return superLoggerComposite;
		}
//		return null;
		return new NullSuperLogger();
	}

}
