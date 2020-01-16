package fernando_santos.treinamento.dia3.factory;

import fernando_santos.treinamento.dia4.composite.NullSuperLogger;
import fernando_santos.treinamento.dia4.composite.SuperLoggerComposite;
import fernando_santos.treinamento.dia4.composite.SuperLoggerConsoleComGrafico;

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
