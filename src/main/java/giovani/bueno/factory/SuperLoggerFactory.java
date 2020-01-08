package giovani.bueno.factory;

public abstract class SuperLoggerFactory {
	
	
	public static SuperLogger createInstance(String tipo) {
		if(tipo.equals("console")) {
			return new Console();	
		}else if(tipo.equals("grafico")) {
			return new Grafico();
		}
		return null;
	}

}
