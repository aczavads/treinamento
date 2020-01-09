package treinamento.guilhermeperes.dia4.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LoggerObserverComposite implements Logger {
	private final List<Logger> loggers = new ArrayList<Logger>();
	
	public LoggerObserverComposite(Logger... loggers) {
		Stream.of(loggers).forEach(logger -> this.loggers.add(logger));
	}

	@Override
	public void log(String text) {
		this.loggers.forEach(logger -> logger.log(text));
	}
}
