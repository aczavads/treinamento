package william.silva.dia3.Factory;

public class App {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.createInstance("grafico");
		logger.log("é nóis!");
	}
}
