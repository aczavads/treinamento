package schiavon.gabriel.dia3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppMaps {

	private static final int QUANTIDADE_MAXIMA_LISTAS_PARCELAS_GERADAS = 10;
	private static final LocalDate DATA_BASE = LocalDate.of(2020, 1, 8);
	private static final int PRAZO_ENTRE_PARCELAS = 30;
	private static final BigDecimal VALOR_TOTAL = BigDecimal.valueOf(1000D).setScale(2, RoundingMode.FLOOR);
	private static final int QUANTIDADE_PARCELAS = 10;

	public static void main(String[] args) {
		List<Parcela> parcelas = gerarParcelas();
		Map<LocalDate, List<Parcela>> mapParcelaPorDia = consolidarParcelas(parcelas);
		printValoresMap(mapParcelaPorDia);
	}

	public static Map<LocalDate, List<Parcela>> consolidarParcelas(List<Parcela> parcelas) {
		Map<LocalDate, List<Parcela>> mapParcelaPorDia = new HashMap<>();
		
		parcelas.stream().forEach(p -> {
			adicionaParcela(mapParcelaPorDia, p);
		});
		
		return mapParcelaPorDia;
	}

	private static List<Parcela> gerarParcelas() {
		List<Parcela> parcelas = new ArrayList<>();
		for (int i = 0; i < QUANTIDADE_MAXIMA_LISTAS_PARCELAS_GERADAS; i++) {
			parcelas.addAll(ParcelaUtil.getParcelas(QUANTIDADE_PARCELAS, VALOR_TOTAL, DATA_BASE, PRAZO_ENTRE_PARCELAS));
		}

		return parcelas;
	}

	private static void printValoresMap(Map<LocalDate, List<Parcela>> mapParcelaPorDia) {
		mapParcelaPorDia.entrySet().forEach(key -> {
			System.out.println(key.getKey());

			key.getValue().stream().forEach(parcela -> System.out.println(parcela));

			System.out.println("\n");
		});
	}

	private static void adicionaParcela(Map<LocalDate, List<Parcela>> mapParcelaPorDia, Parcela p) {
		if (!mapParcelaPorDia.containsKey(p.getDataVencimento())) {
			mapParcelaPorDia.put(p.getDataVencimento(), new ArrayList<>());
		}
		
		mapParcelaPorDia.get(p.getDataVencimento()).add(p);
	}
}
