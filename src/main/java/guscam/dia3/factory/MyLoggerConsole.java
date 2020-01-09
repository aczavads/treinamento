package guscam.dia3.factory;

public class MyLoggerConsole implements MyLogger {

	@Override
	public void log(String message) {
		System.out.println(message);
	}

}
