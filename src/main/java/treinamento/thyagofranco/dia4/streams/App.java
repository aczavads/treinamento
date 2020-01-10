package treinamento.thyagofranco.dia4.streams;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		int[] idades = new int[] {10,12,99,33,45,97,19,23};
		System.out.println(Arrays.stream(idades).average());
		System.out.println(Arrays.stream(idades).sum());
		
		Arrays.stream(idades).filter(v -> v%2==0).forEach(System.out::println);
	}

}
