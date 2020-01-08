package william.silva.dia3.Factory;

public class App {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.createInstance("console");
		logger.log("é nóis!");
	}
}
