package schiavon.gabriel.dia3.patterns.factory;

public interface MyLoggerFactory {

	static MyLogger createInstance(TiposMyLogger tipoLogger) {
		if (tipoLogger.isConsole()) {
			return new LoggerPorConsole();
		} else {
			if (tipoLogger.isGrafico()) {
				return new LoggerPorGrafico();
			}
		}
		
		return null;
	}

}
