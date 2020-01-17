package thyagofranco.dia2;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class AppExceptions {
	
	public static void main(String[] args) {
		int parcelas = Integer.parseInt(args[0]);
		if (parcelas <= 0) {
			throw new RuntimeException(
					"O número de parcelas deve "
					+ "ser maior "
					+ "que zero! [" + parcelas + "]");
		}
		
		System.out.println(parcelas);
		int[] valores = {1,2,3};
		
	}

}
