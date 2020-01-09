package giovani.bueno.dia4;

import java.util.ArrayList;
import java.util.List;

import giovani.bueno.factory.NullSuperLogger;
import giovani.bueno.factory.SuperLogger;

public class SuperLoggerComposite implements SuperLogger {

	private List<SuperLogger> loggers = new ArrayList<SuperLogger>();
	
	public SuperLoggerComposite(SuperLogger... loggersParaAdicionar) {
		for (SuperLogger aAdicionar : loggers) {
			loggers.add(aAdicionar);
		}
		this.loggers.add(new NullSuperLogger());
	}
	
	
	
	public void addLogger(SuperLogger logger) {
		this.loggers.add(logger);
	}
	@Override
	public void log(String message) {
		loggers.forEach(logger ->logger.log(message));
	}

}
