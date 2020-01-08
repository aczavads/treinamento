package treinamento.diegomucheniski.dia3.singleton;

public class Universo {
	
	private static final Universo theUniverse = new Universo();
	
	private Universo() {		
	}
	
	public static Universo getInstance() {
		return theUniverse;
	}

}
