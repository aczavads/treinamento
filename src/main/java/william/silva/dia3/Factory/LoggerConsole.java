package william.silva.dia3.Factory;

public class LoggerConsole implements Logger {

	@Override
	public void log(String mensagem) {
		System.out.println(mensagem);

	}

}
