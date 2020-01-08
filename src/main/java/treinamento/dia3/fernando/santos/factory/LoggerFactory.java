package treinamento.dia3.fernando.santos.factory;


public interface LoggerFactory {

	static SuperLogger createInstance(String logger) {
		if(logger.equals("console")) {
			return new LoggerConsole();
		} else if(logger.equals("grafico")) {
			return new LoggerGrafico();
		}
		return null;
	}

}
