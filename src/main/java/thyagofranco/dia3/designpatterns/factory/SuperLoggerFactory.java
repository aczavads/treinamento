package thyagofranco.dia3.designpatterns.factory;

import thyagofranco.dia4.composer.NullSuperLogger;
import thyagofranco.dia4.composer.SuperLoggerComposite;
import thyagofranco.dia4.composer.SuperLoggerConsoleComGrafico;

public abstract class SuperLoggerFactory implements SuperLogger {
	
	
	public static SuperLogger createInstance(String metodo) {
		if(metodo.equals("console")) {
			return new SuperLoggerConsole();
		}if(metodo.equals("grafico")) {
			return new SuperLoggerGrafico();
		}if(metodo.equals("console-com-grafico")) {
			return new SuperLoggerConsoleComGrafico();
		}if(metodo.equals("console-triplo")) {
			SuperLoggerComposite composite = new SuperLoggerComposite(
					new SuperLoggerConsole(),new SuperLoggerConsole(),new SuperLoggerConsole());
			
			//substituido pelo var args operator ... em SuperLoggerComposite;
			//SuperLoggerComposite composite = new SuperLoggerComposite();
			//composite.addLogger(new SuperLoggerConsole());
			//composite.addLogger(new SuperLoggerConsole());
			//composite.addLogger(new SuperLoggerConsole());
			return composite;
		}
		
		//return null;  NullPointerException
		
		return new NullSuperLogger();
	}
	
	@Override
	public void log(String mensagem) {
		
	}
}





