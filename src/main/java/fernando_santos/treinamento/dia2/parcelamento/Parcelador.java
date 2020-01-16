package fernando_santos.treinamento.dia2.parcelamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fernando_santos.treinamento.dia2.parcelamento.QuantidadeDeParcelasComValorInvalidoException;
import fernando_santos.treinamento.dia2.parcelamento.ValorTotalAParcelarComValorInvalidoException;

public class Parcelador {

	public List<Parcela> realizaParcelamento(double valorTotal, int quantidadeDeParcelas, String dataBase,
			int prazoEmDias) {
		validaParametrosRealizacaoParcelamento(valorTotal, quantidadeDeParcelas);

		BigDecimal valorTotalBigDecimal = BigDecimal.valueOf(valorTotal);
		BigDecimal valorDaParcela = valorTotalBigDecimal.divide(BigDecimal.valueOf(quantidadeDeParcelas), 2,
				RoundingMode.FLOOR);
		BigDecimal valorRestante = valorTotalBigDecimal
				.subtract(valorDaParcela.multiply(BigDecimal.valueOf(quantidadeDeParcelas)));

		List<Parcela> parcelamento = new ArrayList<>();
		
		DateTimeFormatter formatadorStringParaLocalDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataBaseLocalDate = LocalDate.parse(dataBase, formatadorStringParaLocalDate);

		Parcela primeiraParcela = new Parcela(1, dataBaseLocalDate, valorDaParcela.add(valorRestante));
		parcelamento.add(primeiraParcela);

		for (int numeroDaparcela = 2; numeroDaparcela <= quantidadeDeParcelas; numeroDaparcela++) {
			Parcela parcela = new Parcela(numeroDaparcela, dataBaseLocalDate.plusDays(prazoEmDias * (numeroDaparcela - 1)), valorDaParcela);
			parcelamento.add(parcela);
		}

		return parcelamento;
	}

	private static void validaParametrosRealizacaoParcelamento(double valorTotal, int quantidadeDeParcelas) {
		if (quantidadeDeParcelas <= 0) {
			throw new QuantidadeDeParcelasComValorInvalidoException("Quantidade de parcelas deve ser maior que 0.");
		}
		if (valorTotal <= 0) {
			throw new ValorTotalAParcelarComValorInvalidoException();
		}
		if (BigDecimal.valueOf(valorTotal).scale() > 2) {
			throw new ValorTotalAParcelarComValorInvalidoException();
		}
	}

}
