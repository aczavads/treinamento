package treinamento.diegomucheniski.dia3.factory;

import java.util.ArrayList;
import java.util.List;

public class CustomLoggerComposite implements CustomLogger {

	private List<CustomLogger> loggers = new ArrayList<>();

	public void addLogger(CustomLogger logger) {
		this.loggers.add(logger);
	}
	
	@Override
	public void log(String texto) {
		loggers.forEach(logger -> logger.log(texto));
	}

}
