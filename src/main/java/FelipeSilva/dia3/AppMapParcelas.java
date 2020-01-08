package FelipeSilva.dia3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import treinamento.dia2.Parcela;
import treinamento.dia2.ParcelamentoComParcela;

public class AppMapParcelas {
	public static void main(String[] args) {
		Map<String, List<Long>> mapa = new HashMap<>();
		LocalDate dataBase = LocalDate.of(2020, 1, 8);
		int prazoEmDias = 30;
		List<Parcela> parcelas = criarCemParcelas(dataBase, prazoEmDias);
		Map<LocalDate, List<Parcela>> parcelasPorVencimento = agruparParcelasPorVencimento(parcelas);
		imprimirParcelasPorVencimentoNoConsole(parcelasPorVencimento);
	}

	private static List<Parcela> criarCemParcelas(LocalDate dataBase, int prazoEmDias) {
		List<Parcela> parcelas = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			BigDecimal valorParaParcelar = new BigDecimal("10.00").multiply(new BigDecimal(i + 1));
			parcelas.addAll(ParcelamentoComParcela.parcelar(valorParaParcelar, 10, dataBase, prazoEmDias));
			System.out.println(" >>> " + parcelas.size());
		}
		return parcelas;
	}

	private static void imprimirParcelasPorVencimentoNoConsole(Map<LocalDate, List<Parcela>> parcelasPorVencimento) {
		for (java.util.Map.Entry<LocalDate, List<Parcela>> entry : parcelasPorVencimento.entrySet()) {
			System.out.println(entry.getKey());
			for (Parcela parcela : entry.getValue()) {
				System.out.println("" + parcela);
			}
		}
	}

	public static Map<LocalDate, List<Parcela>> agruparParcelasPorVencimento(List<Parcela> parcelas){
		Map<LocalDate,List<Parcela>> parcelasPorVencimento = new HashMap<>();
		for (Parcela parcela : parcelas) {
			if (!parcelasPorVencimento.containsKey(parcela.getVencimento())) {
				parcelasPorVencimento.put(parcela.getVencimento(),new ArrayList<>());
			}
			parcelasPorVencimento.get(parcela.getVencimento()).add(parcela);
		}
		return parcelasPorVencimento;
			}
	}