package valdenir.junior.dia3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import treinamento.dia2.Parcela;
import treinamento.dia2.ParcelamentoComParcela;

public class App {
	public static void main(String[] args) {
		List<Parcela> parcelas = criarCemParcelas();

		Map<LocalDate, List<Parcela>> parcelasAgrupadas = agruparParcelaPorVencimento(parcelas);

		for (LocalDate chave : parcelasAgrupadas.keySet()) {
			System.out.println("Vencimento: " + chave + " / qtd parcelas: " + parcelasAgrupadas.get(chave).size());
		}
	}

	public static List<Parcela> criarCemParcelas() {
		List<Parcela> parcelas = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			parcelas.addAll(ParcelamentoComParcela.parcelar(new BigDecimal(1500 * i).setScale(2, RoundingMode.FLOOR),
					10, LocalDate.of(2020, 1, 8), 30));
		}
		return parcelas;
	}

	public static Map<LocalDate, List<Parcela>> agruparParcelaPorVencimento(List<Parcela> parcelas) {
		Map<LocalDate, List<Parcela>> parcelasAgrupadas = new HashMap<>();
		for (Parcela parcela : parcelas) {
			if (!parcelasAgrupadas.containsKey(parcela.getVencimento()))
				parcelasAgrupadas.put(parcela.getVencimento(), new ArrayList<>());
			parcelasAgrupadas.get(parcela.getVencimento()).add(parcela);
		}
		return parcelasAgrupadas;
	}
}
