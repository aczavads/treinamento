package treinamento.thyagofranco.dia3;

import java.util.Random;

public class AppRandom {
	
	public static void main(String[] args) {
		Random random = new Random();

		int valorInicial = 1000;
		int valorFinal = 5000;

		for(
		int i = 0;i<10;i++)
		{
			double valor = ((valorFinal - valorInicial) * random.nextFloat()) + valorInicial;
			// System.out.println(new BigDecimal(valor).setScale(2, RoundingMode.FLOOR));

		}
	}
	
}
