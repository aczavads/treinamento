package treinamento.thyagofranco.dia3.designpatterns.factory;

public abstract class SuperLoggerFactory implements SuperLogger {
	
	
	public static SuperLogger createInstance(String metodo) {
		if(metodo.equals("console")) {
			return new SuperLoggerConsole();
		}else if(metodo.equals("grafico")) {
			return new SuperLoggerGrafico();
		}
		return null;
	}
	
	@Override
	public void log(String mensagem) {
		
	}
}
