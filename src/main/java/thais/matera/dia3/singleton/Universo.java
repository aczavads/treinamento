package thais.matera.dia3.singleton;

public class Universo {
	private static Universo theUniverse;
	
	private Universo() {}
	
	public static Universo getInstance() {
		if(theUniverse == null)
			theUniverse  = new Universo();
		return theUniverse;
	}
}
