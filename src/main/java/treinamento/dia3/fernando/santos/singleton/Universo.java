package treinamento.dia3.fernando.santos.singleton;

public class Universo {
	
	private static final Universo universo = new Universo();
	
	private Universo() {
	}
	
	public static Universo getInstance() {
		return universo;
	}

}
