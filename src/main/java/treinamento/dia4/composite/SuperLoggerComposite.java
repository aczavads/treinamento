package treinamento.dia4.composite;

import java.util.ArrayList;
import java.util.List;

import treinamento.dia3.factory2.SuperLogger;

public class SuperLoggerComposite implements SuperLogger {
	private List<SuperLogger> loggers = new ArrayList<>();

	public SuperLoggerComposite(SuperLogger... loggersParaAdicionar) {
		for (SuperLogger aAdicionar : loggersParaAdicionar) {
			this.loggers.add(aAdicionar);
		}
		this.loggers.add(new NullSuperLogger());
	}
	
	public void addLogger(SuperLogger logger) {
		this.loggers.add(logger);
	}
	
	@Override
	public void log(String mensagem) {
		loggers.forEach(logger -> logger.log(mensagem));
		/*
		for (SuperLogger superLogger : loggers) {
			superLogger.log(mensagem);
		}
		*/
	}

}
