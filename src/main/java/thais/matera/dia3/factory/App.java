package thais.matera.dia3.factory;

public class App {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.createInstance("graphic");
		
		logger.log("Mensagem importante");
		logger.log("Outra mensagem");
	}
}
