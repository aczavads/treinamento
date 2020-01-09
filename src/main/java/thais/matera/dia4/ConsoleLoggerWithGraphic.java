package thais.matera.dia4;

import thais.matera.dia3.factory.ConsoleLogger;
import thais.matera.dia3.factory.GraphicLogger;
import thais.matera.dia3.factory.Logger;

public class ConsoleLoggerWithGraphic implements Logger {
	private final ConsoleLogger consoleLogger;
	private final GraphicLogger graphicLogger;
	
	public ConsoleLoggerWithGraphic(ConsoleLogger consoleLogger, GraphicLogger graphicLogger) {
		this.consoleLogger = consoleLogger;
		this.graphicLogger = graphicLogger;
	}
	
	public ConsoleLoggerWithGraphic() {
		this.consoleLogger = new ConsoleLogger();
		this.graphicLogger = new GraphicLogger();
	}
	
	@Override
	public void log(String message) {
		this.consoleLogger.log(message);
		this.graphicLogger.log(message);
	}
}
