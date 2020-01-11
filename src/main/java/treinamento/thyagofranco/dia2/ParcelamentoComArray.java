package treinamento.thyagofranco.dia2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ParcelamentoComArray {

	public static void main(String[] args) {
		BigDecimal valor = new BigDecimal(args[0]);
		int quantidadeDeParcelas = Integer.parseInt(args[1]);
		System.out.println("Iniciando parcelamento de " + valor + " em " + quantidadeDeParcelas + " parcela(s).");

		BigDecimal[] parcelas = parcelar(valor, quantidadeDeParcelas);

		for (int parcela = 0; parcela < quantidadeDeParcelas; parcela++) {
			imprimirParcelaNoConsole(parcela + 1, parcelas[parcela]);
		}
	}

	public static BigDecimal[] parcelar(BigDecimal valor, int quantidadeDeParcelas) {
		validarValorAParcelar(valor);
		validarQuantidadeDeParcelas(quantidadeDeParcelas);

		BigDecimal[] parcelas = new BigDecimal[quantidadeDeParcelas];
		BigDecimal valorDaParcela = valor.divide(new BigDecimal(quantidadeDeParcelas), 2, RoundingMode.FLOOR);
		BigDecimal resto = valor.subtract(valorDaParcela.multiply(new BigDecimal(quantidadeDeParcelas)));
		parcelas[0] = valorDaParcela.add(resto);
		for (int parcela = 1; parcela < quantidadeDeParcelas; parcela++) {
			parcelas[parcela] = valorDaParcela;
		}
		return parcelas;
	}

	private static void validarQuantidadeDeParcelas(int quantidadeDeParcelas) {
		if (quantidadeDeParcelas <= 0) {
			throw new NumeroDeParcelasInvalido("O número de parcelas deve ser maior que zero!");
		}
	}

	private static void validarValorAParcelar(BigDecimal valor) {
		if (valor.scale() != 2) {
			throw new ValorAParcelarInvalido("O valor deve ter duas casas decimais!");
		}
		if (valor.compareTo(BigDecimal.ZERO) <= 0) {
			throw new ValorAParcelarInvalido("O valor deve ser maior que zero!");
		}
	}

	private static void imprimirParcelaNoConsole(int numero, BigDecimal valor) {
		System.out.println("Valor da parcela nro [" + numero + "] é " + valor + " reais");
	}
}
