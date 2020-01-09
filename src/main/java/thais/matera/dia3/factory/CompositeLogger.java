package thais.matera.dia3.factory;

import java.util.ArrayList;
import java.util.List;

public class CompositeLogger implements Logger {
	private List<Logger> loggers;
	
	public CompositeLogger(Logger...loggers) {
		this.loggers = new ArrayList<Logger>();
		
		for(Logger logger : loggers) {
			this.addLogger(logger);
		}
		
		this.addLogger(new NullLogger());
	}
	
	public void addLogger(Logger logger) {
		this.loggers.add(logger);
	}
	
	@Override
	public void log(String message) {		
		loggers.forEach(logger -> logger.log(message));
	}
}
