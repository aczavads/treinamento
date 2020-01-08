package treinamento.diegomucheniski.dia3.singleton;

public class RickSanchesSingleton {
	
	private static final RickSanchesSingleton rick = new RickSanchesSingleton();

	private RickSanchesSingleton() {		
	}
	
	public static RickSanchesSingleton getInstance() {
		return rick;
	}
	
	public static String turnAPicle() {
		String text = "I'M A PICKLE RIIICK!!!";
		System.out.println(text);
		return text;
	}
	
}
