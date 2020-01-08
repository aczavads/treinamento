package treinamento.matheus.faxina;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import treinamento.dia2.Parcela;
import treinamento.dia2.ParcelamentoComParcela;

public class AppMapas {

	public static void main(String[] args) {
		LocalDate dataBase = LocalDate.now();
		BigDecimal valorTotal = new BigDecimal("1000.00");
		int diasPrazo = 0;
		int quantidadeParcelas = 12;
		Map<LocalDate, List<Parcela>> map = new HashMap<>();

		gerarCemParcelas(dataBase, valorTotal, diasPrazo, quantidadeParcelas, map);
	}

	private static void gerarCemParcelas(LocalDate dataBase, BigDecimal valorTotal, int diasPrazo,
			int quantidadeParcelas, Map<LocalDate, List<Parcela>> map) {
		for (int parcela = 0; parcela <= 10; parcela++) {
			map.put(dataBase, new ArrayList<Parcela>());
			List<Parcela> parcelas = ParcelamentoComParcela.parcelar(valorTotal, quantidadeParcelas, dataBase,
					diasPrazo);

			map.put(dataBase, parcelas);

			Map<LocalDate, List<Parcela>> agrupados = agruparParcelas(map);
			
		}
	}

	public static void imprimirNoConsole(Map<LocalDate, List<Parcela>> map) {
		for (Entry<LocalDate, List<Parcela>> entry : map.entrySet()) {
			System.out.println("O vencimento: " + entry.getKey() + " tem as seguintes parcelas.");
			for (Parcela parcelaEntry : entry.getValue()) {
				if (entry.getKey().equals(parcelaEntry.getVencimento())) {
					System.out.println("Número: " + parcelaEntry.getNumero() + " Valor: " + parcelaEntry.getValor()
					+ " Vencimento: " + parcelaEntry.getVencimento());
				}
			}
		}
	}
	
	public static Map<LocalDate, List<Parcela>> agruparParcelas(Map<LocalDate, List<Parcela>> map) {
		Map<LocalDate, List<Parcela>> agrupados = new HashMap<>();
		for (Entry<LocalDate, List<Parcela>> entry : map.entrySet()) {
			System.out.println("O vencimento: " + entry.getKey() + " tem as seguintes parcelas.");
			agrupados.put(entry.getKey(), new ArrayList<Parcela>());
			for (Parcela parcelaEntry : entry.getValue()) {
				if (entry.getKey().equals(parcelaEntry.getVencimento())) {
					agrupados.get(entry.getKey()).add(parcelaEntry);
					System.out.println("Número: " + parcelaEntry.getNumero() + " Valor: " + parcelaEntry.getValor()
					+ " Vencimento: " + parcelaEntry.getVencimento());
				}
			}
		}
		
		return agrupados;
	}

}
