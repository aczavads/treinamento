package thyagofranco.dia2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ParcelamentoComParcela {
	public static void main(String[] args) {
		BigDecimal valor = new BigDecimal(args[0]);
		int quantidadeDeParcelas = Integer.parseInt(args[1]);
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataBase = LocalDate.parse(args[2], formatador);
		int prazoEmDias = Integer.parseInt(args[3]);
		System.out.println("Iniciando parcelamento de " 
				+ valor + " em " + quantidadeDeParcelas 
				+ " parcela(s), a partir de " + dataBase + " com prazo de " + prazoEmDias + "dias");

		List<Parcela> parcelas = parcelar(valor, quantidadeDeParcelas, dataBase, prazoEmDias);

//		for (Parcela p : parcelas) {
//			imprimirParcelaNoConsole(p);
//		}
		
		parcelas.forEach(p -> imprimirParcelaNoConsole(p));
	}

	public static List<Parcela> parcelar(BigDecimal valor, int quantidadeDeParcelas, LocalDate dataBase, int prazoEmDias) {
		validarValorAParcelar(valor);
		validarQuantidadeDeParcelas(quantidadeDeParcelas);

		List<Parcela> parcelas = new ArrayList<Parcela>();
		BigDecimal valorDaParcela = valor.divide(new BigDecimal(quantidadeDeParcelas), 2, RoundingMode.FLOOR);
		BigDecimal resto = valor.subtract(valorDaParcela.multiply(new BigDecimal(quantidadeDeParcelas)));
		parcelas.add(new Parcela(1, dataBase.plusDays(prazoEmDias), valorDaParcela.add(resto)));
		for (int parcela = 1; parcela < quantidadeDeParcelas; parcela++) {
			parcelas.add(new Parcela(parcela+1, dataBase.plusDays((parcela+1) * prazoEmDias), valorDaParcela));
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

	private static void imprimirParcelaNoConsole(Parcela p) {
		System.out.println("Valor da parcela nro [" + p.getNumero() + "] é " + p.getValor() + " reais, com vencimento em " + p.getVencimento());
	}
}
