package GLF.dia4.composit;

import java.util.ArrayList;
import java.util.List;

import GLF.dia3.factory2.SuperLogger;

public class SuperLoggerComposit implements SuperLogger {
	
	private List<SuperLogger> loggers = new ArrayList<>();
	
	public void addLogger(SuperLogger logger) {
		this.loggers.add(logger);
	}
	

	
	@Override
	public void log(String mensagem) {
		for (SuperLogger superLogger : loggers) {
			superLogger.log(mensagem);
		}
		
	}

}
