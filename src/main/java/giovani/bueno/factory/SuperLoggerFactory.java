package giovani.bueno.factory;

import giovani.bueno.dia4.SuperLoggerComposite;
import giovani.bueno.dia4.SuperLoggerConsoleComGrafico;

public abstract class SuperLoggerFactory {
	
	
	public static SuperLogger createInstance(String tipo) {
		if(tipo.equals("console")) {
			return new Console();	
		}else if(tipo.equals("grafico")) {
			return new Grafico();
		}else if(tipo.equals("console-com-grafico")) {
			return new SuperLoggerConsoleComGrafico();
		}else if(tipo.equals("console-triplo")) {
			SuperLoggerComposite composite = new SuperLoggerComposite();
			composite.addLogger(new Console());
			composite.addLogger(new Console());
			composite.addLogger(new Console());
			return composite;
		}
		return new NullSuperLogger();
	}
	
	

}
