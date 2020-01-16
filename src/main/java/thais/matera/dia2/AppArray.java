package thais.matera.dia2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class AppArray {
	public static void main(String[] args) {	
		BigDecimal value = BigDecimal.valueOf(Double.parseDouble(args[0]));
		int installments = Integer.parseInt(args[1]);
		
		BigDecimal[] installmentArray = initInstallmentArray(value, installments);
		
		for(int i = 0; i < installments; i++) {
			showInstallment(i+1, installmentArray[i]);
		}
	}
	
	public static BigDecimal[] initInstallmentArray(BigDecimal value, int installments) {
		verifyInput(value, installments);
		
		BigDecimal[] installmentArray = new BigDecimal[installments];
		BigDecimal installmentValue = value.divide(new BigDecimal(installments), 2, RoundingMode.FLOOR);
		BigDecimal rest = value.subtract(installmentValue.multiply(new BigDecimal(installments)));
		
		installmentArray[0] =  installmentValue.add(rest);
		for(int i = 1; i < installments; i++) {
			installmentArray[i] = installmentValue;
		}
		
		return installmentArray;
	}
	
	public static void verifyInput(BigDecimal value, int installments) {
		if(value.scale() != 2) {
			throw new ValueException("value is invalid");
		}
		
		if(installments <= 0) {
			throw new InstallmentException("installments value is less than 0");
		}
		
		if(value.compareTo(BigDecimal.ZERO) < 0) {
			throw new ValueException("value is less than 0");
		}
	}
	
	private static void showInstallment(int number, BigDecimal value) {
		System.out.println("Valor da parcela [" + number + "] é " + value + " reais.");
	}
}
