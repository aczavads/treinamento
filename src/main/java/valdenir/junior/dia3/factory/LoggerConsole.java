package valdenir.junior.dia3.factory;

public class LoggerConsole implements Logger {

	@Override
	public void log(String mensagem) {
		System.out.println(mensagem);
	}

}
