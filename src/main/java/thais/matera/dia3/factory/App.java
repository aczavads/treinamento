package thais.matera.dia3.factory;

public class App {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.createInstance("graphic");
		
		logger.log("Mensagem importante");
		logger.log("Outra mensagem");
		
		Logger loggerTwo = LoggerFactory.createInstance("console-with-graphic");
		
		loggerTwo.log("logger with composition");
		
		Logger loggerComposite = LoggerFactory.createInstance("composite");
				
		loggerComposite.log("composite test");
	}
}
