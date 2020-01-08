package treinamento.guilhermeperes.dia3.patterns.factory;

import java.util.Optional;

public class App {
	public static void main(String[] args) {
		Optional<Logger> myLog = LoggerFactory.createLogger(LoggerType.CONSOLE);
		Optional<Logger> myOtherLog = LoggerFactory.createLogger(LoggerType.POPUP);
		Optional<Logger> noLog = LoggerFactory.createLogger(LoggerType.valueOf("UNIMPLEMENTED_LOG"));
		
		
		if (myLog.isPresent()) {
			myLog.get().log("Guilherme");
		}
		
		if (myOtherLog.isPresent()) {
			myOtherLog.get().log("Guilherme");
		}
		
		if (noLog.isPresent()) {
			noLog.get().log("Guilherme");
		}
	}
}
