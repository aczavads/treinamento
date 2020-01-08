package guscam.dia3.singleton;

public class Singleton {
	private static final Singleton INSTANCIA = new Singleton(); 
	
	private Singleton() {
	}

	public static Singleton getInstance() {
		return INSTANCIA;
	}
}
