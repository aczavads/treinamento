package giovani.bueno.factory;

public class Console implements SuperLogger {

	@Override
	public void log(String message) {
		System.out.println("Mensagem de Log: "+ message);
		
	}
   
	
}
