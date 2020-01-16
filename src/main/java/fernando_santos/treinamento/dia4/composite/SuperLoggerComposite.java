package fernando_santos.treinamento.dia4.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import fernando_santos.treinamento.dia3.factory.SuperLogger;

public class SuperLoggerComposite implements SuperLogger {
	private List<SuperLogger> loggers = new ArrayList<>();
	
	public SuperLoggerComposite(SuperLogger... loggersParaAdicionar) {
		for(SuperLogger paraAdicionar : loggersParaAdicionar) {
			loggers.add(paraAdicionar);
		}
	}
	
	public void addLogger(SuperLogger logger) {
		this.loggers.add(logger);
	}
	
	@Override
	public void log(Level level, String mensagem) {
//		for(SuperLogger superLogger : loggers) {
//			superLogger.log(level, mensagem);
//		}
		loggers.forEach(logger -> logger.log(level, mensagem));
	}

}
