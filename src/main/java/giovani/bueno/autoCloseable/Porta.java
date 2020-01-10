package giovani.bueno.autoCloseable;


public class Porta implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("FECHOU");
		
	}

}
