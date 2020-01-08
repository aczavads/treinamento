package GLF.dia3.factory2;

public abstract class SuperLoggerFactory {

	public static SuperLogger createInstance(String tipo) {
		if(tipo.equals("Console")) {
			return new SuperLoggerConsole();
		} else if (tipo.equals("Grafico")) {
			return new SuperLoggerGrafico();
		}
		return null;
	}
}
