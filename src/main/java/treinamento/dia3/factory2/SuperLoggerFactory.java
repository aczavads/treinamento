package treinamento.dia3.factory2;

public abstract class SuperLoggerFactory {
	//SuperLogger logger = SuperLoggerFactory.createInstance("console");
	public static SuperLogger createInstance(String tipo) {
		if (tipo.equals("console")) {
			return new SuperLoggerConsole();
		} else if (tipo.equals("gráfico")) {
			return new SuperLoggerGrafico();
		}
		return null;
	}

}
