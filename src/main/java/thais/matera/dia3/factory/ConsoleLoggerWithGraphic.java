package thais.matera.dia3.factory;

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
