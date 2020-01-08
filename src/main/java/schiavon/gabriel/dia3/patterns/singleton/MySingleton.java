package schiavon.gabriel.dia3.patterns.singleton;

public class MySingleton {

	private static final MySingleton singleton = new MySingleton();
	
	private MySingleton() {
		
	}
	
	public static MySingleton getInstance() {
		return singleton;
	}
	
}
