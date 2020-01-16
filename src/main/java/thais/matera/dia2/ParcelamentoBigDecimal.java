package thais.matera.dia2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ParcelamentoBigDecimal {
	public static void main(String[] args) {
		BigDecimal value = BigDecimal.valueOf(Double.parseDouble(args[0]));
		int installments = Integer.parseInt(args[1]);
		
		BigDecimal installmentValue = value.divide(new BigDecimal(installments), 2, RoundingMode.FLOOR);
		BigDecimal rest = value.subtract(installmentValue.multiply(new BigDecimal(installments)));

		showInstallment(1, installmentValue.add(rest));
		
		for(int i = 1; i < installments; i++) {						
			showInstallment(i+1, installmentValue);
		}
	}
	
	private static void showInstallment(int number, BigDecimal value) {
		System.out.println("Valor da parcela [" + number + "] é " + value + " reais.");
	}
}
