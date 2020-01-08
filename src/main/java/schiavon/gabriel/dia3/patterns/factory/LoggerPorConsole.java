package schiavon.gabriel.dia3.patterns.factory;

public class LoggerPorConsole implements MyLogger {

	@Override
	public void log(String log) {
		System.out.println(log);
	}

}
