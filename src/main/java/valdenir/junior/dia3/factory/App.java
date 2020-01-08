package valdenir.junior.dia3.factory;

public class App {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.createInstance("console");

		logger.log("Mensagem importante!");
		logger.log("Outra mensagem");
	}
}
