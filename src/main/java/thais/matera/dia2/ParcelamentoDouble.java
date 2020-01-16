package thais.matera.dia2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ParcelamentoDouble {
	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat formater = (DecimalFormat) nf;
		formater.applyPattern("#0.00");
		
		double value = Double.parseDouble(args[0]);
		int installments = Integer.parseInt(args[1]);
		
		System.out.println("Iniciando parcelamento de "
				+ value + " em "
				+ installments + " parcela(s).");
		
		double installmentValue = value/installments;
		installmentValue = Double.parseDouble(formater.format(installmentValue));
		double rest = value - installmentValue*installments;
		
		print(1, installmentValue + rest);
		
		for(int i = 1; i < installments; i++) {						
			print(i+1, installmentValue);
		}
	}
	
	private static void print(int number, double value) {
		System.out.println("Valor da parcela [" + number + "] é " + value + " reais.");
	}
}
