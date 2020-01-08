package valdenir.junior.dia3;

public class Universo {
	private static final Universo universo = new Universo();

	private Universo() {
		super();
	}

	public static Universo getInstance() {
		return universo;
	}
}
