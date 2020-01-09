package treinamento.guilhermeperes.dia3.patterns.factory;

public interface LoggerFactory {
	public static Logger createLogger(Class<?> loggerClass) {
		Logger logger = null;
		
		try {
			logger = (Logger) loggerClass.getConstructor().newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Cannot create new instance of Logger class");
		}
		
		return logger;
	}
}
