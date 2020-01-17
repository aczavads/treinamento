package thyagofranco.dia2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ParcelamentoDouble {
	//java -cp target/classes/ treinamento2.dia2.App 100 7
	// java treinamento2.dia2.App 100.00 2
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		double valor = Double.parseDouble(args[0]);
		int parcelas = Integer.parseInt(args[1]);
		System.out.println("Iniciando parcelamento de " 
				+ valor + " em " 
				+ parcelas + " parcela(s).");
		double valorDaParcela = arredondarValorComDuasCasas(valor/parcelas);
        double resto = valor - (valorDaParcela*parcelas);

        System.out.println("Valor original da parcela:" + (valor/parcelas));
        imprimirParcelaNoConsole(1, arredondarValorComDuasCasas((valorDaParcela+resto)));
		for (int parcela=1; parcela < parcelas; parcela++) {
	        imprimirParcelaNoConsole(parcela+1, valorDaParcela);
		}
	}
	private static void imprimirParcelaNoConsole(int numero, double valor) {
		System.out.println("Valor da parcela nro [" + numero + "] é " + valor + " reais");
	}
	private static double arredondarValorComDuasCasas(double valor) {
		DecimalFormat formatador = new DecimalFormat("#0.00");
		return Double.parseDouble(formatador.format(valor));		
	}
}
