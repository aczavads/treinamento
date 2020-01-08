package valdenir.junior.dia3.factory;

public abstract class LoggerFactory {

	static Logger createInstance(String tipoLog) {
		if ("console".equals(tipoLog))
			return new LoggerConsole();
		if ("grafico".equals(tipoLog))
			return new LoggerGrafico();
		return null;
	}
}
