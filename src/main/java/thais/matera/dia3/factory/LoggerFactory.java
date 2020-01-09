package thais.matera.dia3.factory;

import thais.matera.dia4.ConsoleLoggerWithGraphic;
import thais.matera.dia4.NullLogger;

public abstract class LoggerFactory {
	public static Logger createInstance(String type) {
		Logger logger;
		
		if(type.equalsIgnoreCase("console")) {
			logger = new ConsoleLogger();
		}else if(type.equalsIgnoreCase("graphic")) {
			logger = new GraphicLogger();
		}else if(type.equalsIgnoreCase("console-with-graphic")) {
			logger = new ConsoleLoggerWithGraphic();
		}else if(type.equals("composite")) {
			logger = new CompositeLogger(new ConsoleLogger(), new GraphicLogger());
		}else {
			logger = new NullLogger();
		}
		
		return logger;
	}
}
