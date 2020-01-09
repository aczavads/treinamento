package treinamento.guilhermeperes.dia3.patterns.factory;

public class App {
	public static void main(String[] args) {
		Logger myLog = LoggerFactory.createLogger(ConsoleLogger.class);
		Logger myOtherLog = LoggerFactory.createLogger(PopupLogger.class);
		
		myLog.log("Guilherme");
		myOtherLog.log("Guilherme");
	}
}
