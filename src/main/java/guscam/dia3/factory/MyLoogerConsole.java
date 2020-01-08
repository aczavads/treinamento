package guscam.dia3.factory;

public class MyLoogerConsole implements MyLogger {

	@Override
	public void log(String message) {
		System.out.println(message);
	}

}
