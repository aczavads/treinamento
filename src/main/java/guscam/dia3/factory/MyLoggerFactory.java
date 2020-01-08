package guscam.dia3.factory;

public interface MyLoggerFactory {

	static MyLogger createInstance(String tipoDoLog) {
		if (tipoDoLog.equalsIgnoreCase("console")) {
			return new MyLoogerConsole();
		}
		return new MyLoggerGrafico();
	}

}
