package treinamento.guilhermeperes.dia4.observer;

public class App {
	public static void main(String[] args) {
		Logger variosLoggers = new LoggerObserverComposite(
				System.out::println,
				text -> System.out.println("Grafico: " + text),
				text -> System.out.println("Terceiro Log: " + text)
			);
		
		variosLoggers.log("Guilherme");
	}
}
