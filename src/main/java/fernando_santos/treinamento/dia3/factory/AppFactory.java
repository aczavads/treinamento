package fernando_santos.treinamento.dia3.factory;

import java.util.logging.Level;

public class AppFactory {
	public static void main(String[] args) {
		
		SuperLogger logger = LoggerFactory.createInstance("console-com-grafico");
		
		logger.log(Level.WARNING, "Mensagem importante!");
		logger.log(Level.INFO, "Outra meensagem.");
	}

}
