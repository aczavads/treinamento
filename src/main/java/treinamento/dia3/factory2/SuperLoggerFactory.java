package treinamento.dia3.factory2;

import treinamento.dia4.composite.NullSuperLogger;
import treinamento.dia4.composite.SuperLoggerComposite;
import treinamento.dia4.composite.SuperLoggerConsoleComGrafico;

public abstract class SuperLoggerFactory {
	//SuperLogger logger = SuperLoggerFactory.createInstance("console");
	public static SuperLogger createInstance(String tipo) {
		if (tipo.equals("console")) {
			return new SuperLoggerConsole();
		} 
		if (tipo.equals("gráfico")) {
			return new SuperLoggerGrafico();
		} 
		if (tipo.equals("console-com-gráfico")) {
			return new SuperLoggerConsoleComGrafico();
		}
		if (tipo.equals("console-triplo")) {
			SuperLoggerComposite composite = new SuperLoggerComposite(
					new SuperLoggerConsole(), new SuperLoggerConsole(), new SuperLoggerConsole());
//			SuperLoggerComposite composite = new SuperLoggerComposite();
//			composite.addLogger(new SuperLoggerConsole());
//			composite.addLogger(new SuperLoggerConsole());
//			composite.addLogger(new SuperLoggerConsole());
			return composite;
		}
		return new NullSuperLogger();
	}

}
