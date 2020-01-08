package treinamento.dia3.fernando.santos.factory;

import java.util.logging.Level;

public class AppFactory {
	public static void main(String[] args) {
		
//		SuperLogger logger = LoggerFactory.createInstance("console");
		SuperLogger logger = LoggerFactory.createInstance("grafico");
		
		logger.log(Level.WARNING, "Mensagem importante!");
		logger.log(Level.INFO, "Outra meensagem.");
	}

}
