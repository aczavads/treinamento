package thyagofranco.dia3.designpatterns.factory;

public class SuperLoggerConsole implements SuperLogger {

	@Override
	public void log(String mensagem) {
		System.out.println(mensagem);
		
	}
	

}
