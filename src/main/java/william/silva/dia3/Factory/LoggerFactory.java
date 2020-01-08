package william.silva.dia3.Factory;

public class LoggerFactory {
	public static Logger createInstance(String tipo) {
		if (tipo.equalsIgnoreCase("grafico")) {
			return new LoggerGrafico();
		} else if (tipo.equalsIgnoreCase("console")) {
			return new LoggerConsole();
		}
		return null;
	}
}
