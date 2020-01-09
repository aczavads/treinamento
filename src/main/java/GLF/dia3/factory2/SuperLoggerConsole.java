package GLF.dia3.factory2;

public class SuperLoggerConsole implements SuperLogger {

	@Override
	public void log(String mensagem) {
		System.out.println(mensagem);
		
	}

}
