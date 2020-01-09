package treinamento.dia3.factory2;


import polianadias2.SuperLoggerConsoleComGrafico;

public abstract class SuperLoggerFactory {
	//SuperLogger logger = SuperLoggerFactory.createInstance("console");
	public static SuperLogger createInstance(String tipo) {
		if (tipo.equals("console")) {
			return new SuperLoggerConsole();
		} else if (tipo.equals("gráfico")) {
			return new SuperLoggerGrafico();
		}else if (tipo.equals("Console-com-gráfico")) {
			return new SuperLoggerConsoleComGrafico();
		}
		
		if (tipo.equals("console-triplo")) {
			SuperLoggerComposite compiste = new SuperLoggerComposite();
			composite.addLogger(new SuperLoggerConsole());
			
		}
		return null;
	}

}
