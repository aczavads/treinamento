package treinamento.dia1;

import java.util.Arrays;

public class App {
	
	public static void main(String[] args) {
		double[] pesos = {55.65, 98.77, 54.10, 48.0};
		double media = Arrays.stream(pesos).sum()/pesos.length;
		System.out.println(media);
	}
	
}
