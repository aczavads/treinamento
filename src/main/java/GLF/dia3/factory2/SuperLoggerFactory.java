package GLF.dia3.factory2;

import GLF.dia4.composit.NullSuperLogger;
import GLF.dia4.composit.SuperLoggerComposit;
import GLF.dia4.composit.SuperLoggerConsoleComGrafico;

public abstract class SuperLoggerFactory {

	public static SuperLogger createInstance(String tipo) {
		if(tipo.equals("console")) {
			return new SuperLoggerConsole();
		}  
			if (tipo.equals("grafico")) {
			return new SuperLoggerGrafico();
		} 
			if (tipo.equals("console-com-grafico")) {
			return new SuperLoggerConsoleComGrafico();
		}
		 if (tipo.equals("console-triplo")) {
			SuperLoggerComposit composite = new SuperLoggerComposit();
			composite.addLogger(new SuperLoggerConsole());
			composite.addLogger(new SuperLoggerConsole());
			composite.addLogger(new SuperLoggerConsole());
			 
			 return composite;
		}
		return new NullSuperLogger();
	}
}
