package thais.matera.dia3.factory;

public abstract class LoggerFactory {
	public static Logger createInstance(String type) {
		Logger logger;
		
		if(type.equalsIgnoreCase("console")) {
			logger = new ConsoleLogger();
		}else if(type.equalsIgnoreCase("graphic")) {
			logger = new GraphicLogger();
		}else {
			logger = null;
		}
		
		return logger;
	}
}
