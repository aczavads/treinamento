package william.silva.dia3;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import treinamento.dia2.Parcela;
import treinamento.dia2.ParcelamentoComParcela;

public class App {
	public static void main(String[] args) {
		List<Parcela> todasParcelas = gerarCemParcelas("1500.00");
		Map<LocalDate, List<Parcela>> boletos = gerarMapDeParcelas(todasParcelas);
		imprimirMapDeParcelas(boletos);
	}

	public static void imprimirMapDeParcelas(Map<LocalDate, List<Parcela>> boletos) {
		for (Entry<LocalDate, List<Parcela>> entry : boletos.entrySet()) {
			System.out.println("data de vencimento: " + entry.getKey());
			for (Parcela parcela : entry.getValue()) {
				System.out.println("      -> " + parcela.toString());
			}
		}
	}

	public static Map<LocalDate, List<Parcela>> gerarMapDeParcelas(List<Parcela> todasParcelas) {
		Map<LocalDate, List<Parcela>> boletos = new HashMap<>();

		for (Parcela parcela : todasParcelas) {
			if (!boletos.containsKey(parcela.getVencimento())) {
				boletos.put(parcela.getVencimento(), new ArrayList<Parcela>());
			}
			boletos.get(parcela.getVencimento()).add(parcela);
		}
		return boletos;
	}

	public static List<Parcela> gerarCemParcelas(String valor) {
		List<Parcela> todasParcelas = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			BigDecimal valorBigDecimal = new BigDecimal(i + 1).multiply(new BigDecimal(valor));
			List<Parcela> listaDeParcelas = ParcelamentoComParcela
					.parcelar(new BigDecimal(String.valueOf(valorBigDecimal)), 10, LocalDate.now(), 30);
			todasParcelas.addAll(listaDeParcelas);
		}
		return todasParcelas;
	}

}
