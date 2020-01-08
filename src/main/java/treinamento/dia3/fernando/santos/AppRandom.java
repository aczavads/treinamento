package treinamento.dia3.fernando.santos;

import java.util.Random;

public class AppRandom {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		int valorInicial = 1000;
		int valorFinal = 5000;
		
		for(int i = 0; i < 10; i++) {
			double valor = ((valorFinal - valorInicial) * random.nextFloat()) + valorInicial;
			System.out.println(valor);
		}
		
		
	}

}
