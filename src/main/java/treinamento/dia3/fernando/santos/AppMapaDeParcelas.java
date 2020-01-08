package treinamento.dia3.fernando.santos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import treinamento.dia2.fernando.santos.parcelamento.Parcela;
import treinamento.dia2.fernando.santos.parcelamento.Parcelador;

public class AppMapaDeParcelas {
	public static void main(String[] args) {

		Parcelador parcelador = new Parcelador();
		double valorBase = 1000;
		int quantidadeDeParcelas = 10;
		String dataBase = "08/01/2020";
		int prazoEmDias = 30;

		List<Parcela> todasParcelas = criarCemParcelas(parcelador, valorBase, quantidadeDeParcelas, dataBase, prazoEmDias);
		Map<LocalDate, List<Parcela>> todasParcelasPorData = agruparParcelasPorDataDeVencimento(todasParcelas);

		for (Entry<LocalDate, List<Parcela>> entry : todasParcelasPorData.entrySet()) {
			System.out.println("Valores do dia " + entry.getKey());
			for (Parcela parcela : entry.getValue()) {
				System.out.println(
						"	Valor: " + parcela.getValorDaParcela() + "	vencimento: " + parcela.getDataDeVencimento());
			}

		}

	}

	public static Map<LocalDate, List<Parcela>> agruparParcelasPorDataDeVencimento(List<Parcela> todasParcelas) {
		Map<LocalDate, List<Parcela>> todasParcelasPorData = new HashMap<>();
		for (int i = 0; i < todasParcelas.size(); i++) {
			Parcela parcela = todasParcelas.get(i);
			LocalDate dataDeVencimentoDaParcela = parcela.getDataDeVencimento();
			if (todasParcelasPorData.containsKey(dataDeVencimentoDaParcela)) {
				todasParcelasPorData.get(dataDeVencimentoDaParcela).add(parcela);
			} else {
				List<Parcela> listaDeParcelas = new ArrayList<>();
				listaDeParcelas.add(parcela);
				todasParcelasPorData.put(dataDeVencimentoDaParcela, listaDeParcelas);
			}
		}
		return todasParcelasPorData;
	}

	private static List<Parcela> criarCemParcelas(Parcelador parcelador, double valorBase, int quantidadeDeParcelas,
			String dataBase, int prazoEmDias) {
		List<Parcela> todasParcelas = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			List<Parcela> parcelamento = parcelador.realizaParcelamento(valorBase * (i + 1), quantidadeDeParcelas,
					dataBase, prazoEmDias);
			todasParcelas.addAll(parcelamento);
		}
		return todasParcelas;
	}

}
