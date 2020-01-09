package treinamento.dia3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AppRandom {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		int valorInicial = 1000;
		int valorFinal = 5000;
		Set<BigDecimal> valores = new HashSet<>();
		for (int i = 0; i < 100_000_000; i++) {
			double valor = ((valorFinal - valorInicial) * random.nextFloat()) + valorInicial;
			//System.out.println(new BigDecimal(valor).setScale(2, RoundingMode.FLOOR));
			valores.add(new BigDecimal(valor).setScale(2, RoundingMode.FLOOR));
		}
		System.out.println("Fim.");
	}

}
