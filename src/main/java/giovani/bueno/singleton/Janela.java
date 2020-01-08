package giovani.bueno.singleton;

public class Janela {

	private static  Janela getInstance = new Janela();

	private Janela() {
		
	}
    
	public static Janela getInstance() {
		if(getInstance == null) getInstance = new Janela();
		return getInstance; 
	}
}
