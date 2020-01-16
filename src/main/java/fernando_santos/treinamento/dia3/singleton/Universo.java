package fernando_santos.treinamento.dia3.singleton;

public class Universo {
	
	private static final Universo universo = new Universo();
	
	private Universo() {
	}
	
	public static Universo getInstance() {
		return universo;
	}

}
