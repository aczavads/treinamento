package treinamento.matheus.faxina;

public class EuSouUmSingleton {
	
	private static final EuSouUmSingleton euSouUmSingleton = new EuSouUmSingleton();
	
	private EuSouUmSingleton() {
	}
	
	public static EuSouUmSingleton getInstance() {
		return euSouUmSingleton;
	}

}
