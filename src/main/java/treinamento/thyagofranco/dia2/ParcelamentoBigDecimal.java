package treinamento.thyagofranco.dia2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ParcelamentoBigDecimal {
	
	public static void main(String[] args) {
		BigDecimal valor = new BigDecimal(args[0]);
		int parcelas = Integer.parseInt(args[1]);
		System.out.println("Iniciando parcelamento de " 
				+ valor + " em " 
				+ parcelas + " parcela(s).");
		
		BigDecimal valorDaParcela = valor
				.divide(new BigDecimal(parcelas), 2, RoundingMode.FLOOR);
		BigDecimal resto = valor.subtract(valorDaParcela.multiply(new BigDecimal(parcelas)));
		imprimirParcelaNoConsole(1, valorDaParcela.add(resto));
		for (int parcela=1;parcela < parcelas; parcela++) {
			imprimirParcelaNoConsole(parcela+1, valorDaParcela);
		}
	}
	
	
	private static void imprimirParcelaNoConsole(int numero, BigDecimal valor) {
		System.out.println("Valor da parcela nro [" + numero + "] é " + valor + " reais");
	}
	

}
