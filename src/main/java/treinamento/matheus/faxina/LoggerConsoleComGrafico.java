package treinamento.matheus.faxina;

public class LoggerConsoleComGrafico implements Loggerr {

	private final LoggerGrafico loggerGrafico;
	private final LoggerConsole loggerConsole;

	public LoggerConsoleComGrafico() {
		this.loggerConsole = new LoggerConsole();
		this.loggerGrafico = new LoggerGrafico();
	}

	public LoggerConsoleComGrafico(LoggerConsole loggerConsole, LoggerGrafico loggerGrafico) {
		this.loggerConsole = loggerConsole;
		this.loggerGrafico = loggerGrafico;
	}

	@Override
	public void log(String string) {
		this.loggerConsole.log(string);
		this.loggerGrafico.log(string);
	}

}
