package treinamento.guilhermeperes.dia3.patterns.singleton;

public class Database {
	
	private static final Database instance = new Database();
	
	private Database() {
	}
	
	public static Database getInstance() {
		return instance;
	}
	
	public void connect() {
		System.out.println("Connecting...");
	}
	
	public void disconnect() {
		System.out.println("Disconnecting...");
	}
}
