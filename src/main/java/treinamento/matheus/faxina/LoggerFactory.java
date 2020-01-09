package treinamento.matheus.faxina;

public abstract class LoggerFactory {

	public static Loggerr createInstance(String tipo) {
		if (tipo.equals("console")) {
			return new LoggerConsole();
		} else if (tipo.equals("grafico")) {
			return new LoggerGrafico();
		} else if (tipo.equals("console-com-grafico")) {
			return new LoggerConsoleComGrafico();
		} else if (tipo.equals("console-triplo")) {
			LoggerComposite loggerComposite = new LoggerComposite();
			loggerComposite.addLogger(new LoggerConsole());
			loggerComposite.addLogger(new LoggerConsole());
			loggerComposite.addLogger(new LoggerConsole());
			return loggerComposite;
		}
		return new NullLogger();
	}

}
