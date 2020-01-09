package treinamento.matheus.faxina;

import java.util.ArrayList;
import java.util.List;

public class LoggerComposite implements Loggerr {

	private List<Loggerr> loggers = new ArrayList<Loggerr>();
	
	public void addLogger(Loggerr logger) {
		this.loggers.add(logger);
	}
	
	@Override
	public void log(String string) {
		loggers.forEach(logger -> logger.log(string));
	}

}
