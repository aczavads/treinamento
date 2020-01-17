package thyagofranco.dia2;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class AppArrays {
	
	public static void main(String[] args) {
		
		int[] idades = {10,77,42,23,22,25,29,31,45};
		int[] valores = new int[10];
		Integer[] valoresInteger;
		int quantidade = 3;
		BigDecimal[] parcelas = new BigDecimal[quantidade];
		
		int total = IntStream.of(idades).sum();
		
 		System.out.println(total);
	}

}
