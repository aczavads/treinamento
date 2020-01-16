package fernando_santos.treinamento.dia4.composite;

import java.util.logging.Level;

import fernando_santos.treinamento.dia3.factory.LoggerFactory;
import fernando_santos.treinamento.dia3.factory.SuperLogger;

public class AppComposite {
	public static void main(String[] args) {
//		SuperLogger logger = LoggerFactory.createInstance("console-com-grafico");
//		SuperLogger logger = LoggerFactory.createInstance("console-triplo");
		SuperLogger logger = LoggerFactory.createInstance("logger-inexistente");

		logger.log(Level.WARNING, "Mensagem importante!");
		logger.log(Level.INFO, "Outra meensagem.");
	}

}
