package fernando_santos.treinamento.dia3.singleton;

public class FernandoSingleton {
	
	//https://sourcemaking.com/design_patterns/singleton
	
	private static FernandoSingleton fernandoSingleton;
	
	private FernandoSingleton() {
	}
	
	public static FernandoSingleton getInstance() {
		if(fernandoSingleton == null) {
			fernandoSingleton = new FernandoSingleton();
		}
		return fernandoSingleton;
	}

}
