package thais.matera.dia3.factory;

public class ConsoleLogger implements Logger {
	
	@Override
	public void log(String message) {
		System.out.println(message);
	}
}