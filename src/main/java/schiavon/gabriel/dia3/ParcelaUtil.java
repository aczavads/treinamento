package schiavon.gabriel.dia3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import schiavon.gabriel.dia3.Exceptions.NumeroParcelasInvalidoException;
import schiavon.gabriel.dia3.Exceptions.QuantidadeDiasMinimosEntreParcelasException;
import schiavon.gabriel.dia3.Exceptions.ValorTotalParcelasInvalidoException;

public class ParcelaUtil {

	private static final int QUANTIDADE_DIAS_MINIMOS_ENTRE_PARCELAS = 15;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		int numeroParcelas = Integer.parseInt(args[0]);
		BigDecimal valorTotal = new BigDecimal(args[1]);
		LocalDate dataBase = LocalDate.parse(args[2], formatter);
		int prazoEntreParcelas = Integer.parseInt(args[3]);
		
		List<Parcela> parcelas = getParcelas(numeroParcelas, valorTotal, dataBase, prazoEntreParcelas);
		parcelas.stream().forEach(p -> System.out.println(p.toString()));
	}

	public static List<Parcela> getParcelas(int numeroParcelas, BigDecimal valorTotal, LocalDate hoje,
			int prazoEntreParcelas) {
		validarEntradas(numeroParcelas, valorTotal, prazoEntreParcelas);
		List<Parcela> parcelas = new ArrayList<>();

		LocalDate dataVencimento = calculaProximaDataVencimento(hoje, prazoEntreParcelas);
		BigDecimal valorPorParcela = valorTotal.divide(new BigDecimal(numeroParcelas), 2, RoundingMode.FLOOR);
		BigDecimal diferencaParaValorTotal = calculaDiferencaDeParcelasParaValorTotal(valorPorParcela, numeroParcelas,
				valorTotal);

		parcelas.add(criaParcela(1, dataVencimento, valorPorParcela.add(diferencaParaValorTotal)));
		for (int i = 1; i < numeroParcelas; i++) {
			dataVencimento = dataVencimento.plusDays(prazoEntreParcelas);
			parcelas.add(criaParcela(i + 1, dataVencimento, valorPorParcela));
		}

		return parcelas;
	}

	private static LocalDate calculaProximaDataVencimento(LocalDate dataVencimento, int prazoEntreParcelas) {
		dataVencimento = dataVencimento.plusDays(prazoEntreParcelas);
		return dataVencimento;
	}

	private static Parcela criaParcela(int numeroParcela, LocalDate dataVencimento, BigDecimal valorParcela) {
		return new Parcela(numeroParcela, dataVencimento, valorParcela);
	}

	private static BigDecimal calculaDiferencaDeParcelasParaValorTotal(BigDecimal valorPorParcela, int numeroParcelas,
			BigDecimal valorTotal) {
		return valorTotal.subtract(valorPorParcela.multiply(new BigDecimal(numeroParcelas)));
	}

	private static void validarEntradas(int numeroParcelas, BigDecimal valorTotal, int prazoEntreParcelas) {
		if (numeroParcelas <= 0) {
			throw new NumeroParcelasInvalidoException("Número de parcelas não pode ser menor ou igual a zero.");
		}

		if (valorTotal.compareTo(BigDecimal.ZERO) <= 0) {
			throw new ValorTotalParcelasInvalidoException(
					"Valor total das parcelas não pode ser menor ou igual a zero.");
		}

		if (valorTotal.scale() != 2) {
			throw new ValorTotalParcelasInvalidoException("Precisão das casas decimais inválidos");
		}

		if (prazoEntreParcelas < QUANTIDADE_DIAS_MINIMOS_ENTRE_PARCELAS) {
			throw new QuantidadeDiasMinimosEntreParcelasException(
					"O prazo entre as parcelas precisa ser maior que " + QUANTIDADE_DIAS_MINIMOS_ENTRE_PARCELAS);
		}
	}
}
