package giovanibueno.dia3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javafx.util.converter.LocalDateStringConverter;
import treinamento.dia2.Parcela;
import treinamento.dia2.ParcelamentoComParcela;

public class AgrupamentoDeParcelasPorVencimento {

	public static void main(String[] args) {
		/*
		 * Map<String, List<Long>> mapa = new HashMap<>(); mapa.put("PR", new
		 * ArrayList<Long>()); mapa.put("SC", new ArrayList<Long>()); mapa.put("AC", new
		 * ArrayList<Long>());
		 * 
		 * mapa.get("PR").add(100L); mapa.get("PR").add(100L); mapa.get("PR").add(100L);
		 * 
		 * mapa.get("PR").remove(0);
		 * 
		 * for (Long valor : mapa.get("PR")) { System.out.println(valor);
		 * 
		 * }
		 * 
		 * for(Entry<String,List<Long>> entry : mapa.entrySet()) {
		 * System.out.println("valores do " + entry.getKey()); for (Long valor :
		 * entry.getValue()) { System.out.println(" " + valor); } }
		 * 
		 * System.out.println("SP TEM NO MAPA? "+ mapa.containsKey("SP"));
		 */
		List<Parcela> parcelas = gerarCemParcelas();
		Map<LocalDate, List<Parcela>> parcelasPorVencimento = consolidarParcelas(parcelas);
		imprimirParcelasPorVencimento(parcelasPorVencimento);

	}

	private static List<Parcela> gerarCemParcelas() {
		List<Parcela> parcelas = new ArrayList<>();
		LocalDate dataBase = LocalDate.now();
		Map<LocalDate, List<String>> mapaParcelas = new HashMap<>();
   		for (int i = 0; i < 10; i++) {
   			int numAleatorio = (int)(Math.random() * 10 ) + 100;
			parcelas.addAll(ParcelamentoComParcela.parcelar(
					new BigDecimal(numAleatorio).setScale(2), 10,
					dataBase, 30));
		}
		return parcelas;
	}

	public static Map<LocalDate, List<Parcela>> consolidarParcelas(List<Parcela> parcelas) {
		Map<LocalDate, List<Parcela>> parcelasPorVencimento = new HashMap<>();
		for (Parcela parcela : parcelas) {
			if (!parcelasPorVencimento.containsKey(parcela.getVencimento())) {
				parcelasPorVencimento.put(parcela.getVencimento(), new ArrayList<>());
			}
			parcelasPorVencimento.get(parcela.getVencimento()).add(parcela);
		}
		return parcelasPorVencimento;
	}

	private static void imprimirParcelasPorVencimento(Map<LocalDate, List<Parcela>> parcelasVencimento) {
		for (Entry<LocalDate, List<Parcela>> entry : parcelasVencimento.entrySet()) {
			System.out.println(entry.getKey());
			for (Parcela parcela : entry.getValue()) {
				System.out.println(" " + parcela);
			}
		}
	}

}
