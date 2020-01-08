package treinamento.guilhermeperes.dia3.patterns.factory;

public class ConsoleLogger implements Logger {

	@Override
	public void log(String text) {
		System.out.println(text);
	}
}
