package treinamento.guilhermeperes.dia4.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import treinamento.guilhermeperes.dia3.patterns.factory.Logger;

public class LoggerComposite implements Logger {
	private final List<Logger> loggers = new ArrayList<>();
	
	public LoggerComposite(Logger... loggers) {
		Stream.of(loggers).forEach(logger -> this.loggers.add(logger));
		
		this.addLogger(new NullLogger());
	}
	
	public void addLogger(Logger logger) {
		this.loggers.add(logger);
	}

	@Override
	public void log(String text) {
		this.loggers.forEach(logger -> logger.log(text));
	}
}
