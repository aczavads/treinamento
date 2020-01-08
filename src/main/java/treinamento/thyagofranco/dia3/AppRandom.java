package treinamento.thyagofranco.dia3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class AppRandom {
	Random random = new Random();
	
	int valorInicial = 1000;
	int valorFinal = 5000;
	
	for (int i = 0; i < 10; i++) {
		double valor = ((valorFinal - valorInicial) * random.nextFloat()) + valorInicial;
		//System.out.println(new BigDecimal(valor).setScale(2, RoundingMode.FLOOR));
		
	}
}


