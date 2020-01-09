package treinamento.dia4.fernando.santos.composite;

import java.util.logging.Level;

import treinamento.dia3.fernando.santos.factory.LoggerFactory;
import treinamento.dia3.fernando.santos.factory.SuperLogger;

public class AppComposite {
	public static void main(String[] args) {
//		SuperLogger logger = LoggerFactory.createInstance("console-com-grafico");
//		SuperLogger logger = LoggerFactory.createInstance("console-triplo");
		SuperLogger logger = LoggerFactory.createInstance("logger-inexistente");

		logger.log(Level.WARNING, "Mensagem importante!");
		logger.log(Level.INFO, "Outra meensagem.");
	}

}
