package william.dia3;

public class William {
	
	private static final William instance = new William();
	public static William getInstance() {
		return instance;
	}

	private William() {
		
	}
}
