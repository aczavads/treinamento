package guscam.dia3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import treinamento.dia2.Parcela;
import treinamento.dia2.ParcelamentoComParcela;

public class MapaDeParcelas {

	public static void main(String[] args) {
		List<Parcela> todasParcelas = new ArrayList<Parcela>();
		Map<LocalDate, List<Parcela>> parcelasPorVencimento = new HashMap<LocalDate, List<Parcela>>();

		todasParcelas = criarListaDeParcelas();
		parcelasPorVencimento = retornarParcelasPorVencimento(todasParcelas);
		
		imprimirParcelasPorVencimento(parcelasPorVencimento);

	}

	private static void imprimirParcelasPorVencimento(Map<LocalDate, List<Parcela>> parcelasPorVencimento) {
		for (Entry<LocalDate, List<Parcela>> entry : parcelasPorVencimento.entrySet()) {
			System.out.println(entry.getKey());
			for (Parcela parcela : entry.getValue()) {
				System.out.print("numero : " + parcela.getNumero());
				System.out.print(" valor: " + parcela.getValor());
				System.out.println(" data vencimento: " + parcela.getVencimento());
			}
		}
	}

	private static List<Parcela> criarListaDeParcelas() {
		List<Parcela> todasParcelas = new ArrayList<Parcela>();
		for (int i = 0; i < 9; i++) {
			todasParcelas.addAll(ParcelamentoComParcela.parcelar(
					new BigDecimal("100.00").multiply(new BigDecimal(i + 1)), 10, LocalDate.of(2020, 01, 20), 30));
		}
		return todasParcelas;
	}

	public static Map<LocalDate, List<Parcela>> retornarParcelasPorVencimento(List<Parcela> todasParcelas) {
		Map<LocalDate, List<Parcela>> parcelasPorVencimento = new HashMap<LocalDate, List<Parcela>>();
		for (Parcela parcela : todasParcelas) {
			if (!parcelasPorVencimento.containsKey(parcela.getVencimento())) {
				parcelasPorVencimento.put(parcela.getVencimento(), new ArrayList<Parcela>());
			}
			parcelasPorVencimento.get(parcela.getVencimento()).add(parcela);
		}
		return parcelasPorVencimento;
	}

}
