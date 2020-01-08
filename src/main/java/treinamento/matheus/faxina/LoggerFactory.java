package treinamento.matheus.faxina;

public abstract class LoggerFactory {

	public static Loggerr createInstance(String tipo) {
		if (tipo.equals("console")) {
			return new LoggerConsole();
		} else if (tipo.equals("grafico")) {
			return new LoggerGrafico();
		}
		return null;
	}

}
