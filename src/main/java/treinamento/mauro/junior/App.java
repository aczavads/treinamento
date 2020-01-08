package treinamento.mauro.junior;

import java.lang.Thread.State;
import java.math.BigDecimal;
import java.security.KeyStore.Entry;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import treinamento.dia2.Parcela;
import treinamento.dia2.ParcelamentoComParcela;

public class App {

	private static final int Parcela = 0;
	private static final int List = 0;
	private static final int LocalDate = 0;

	public static Map<LocalDate, List<Parcela>> main(String[] args) {
		LocalDate dataBase = LocalDate.now(2020, 1, 8);
		int diasPrazo = 30;
		BigDecimal valorBase = new BigDecimal("1500.00");
		
		Object prazoEmDias;
		List<Parcela> parcelas = criarCemParcelas (valorBase, dataBase, prazoEmDias);
		
		Map<LocalDate, List<Parcela>> parcelasPorVencimento = agruparParcelasPorVencimento(parcelas);
		
		imprimirParcelasPorVencimentoNoConsole(parcelasPorVencimento);
	{
		
	private static void imprimirParcelasPorVencimentoNoConsole(Map<LocalDate, List<Parcelas>> parcelasPorVencimento) {
		for (Entry<LocalDate, List<Parcela>> entry : parcelasPorVecimento.entrySet()) {
			System.out.println(entry.getKey());
			for (Parcela parcela : entry.getValue()) {
				System.out.println("     " + parcela);
			}
		}
	}
}
		
	private static Map<LocalDate, List<Parcela>> agruparParcelasProVencimento(List<Parcela> parcelas);
		Map<LocalDate, List<Parcela>> parcelasPorVencimento1 = new HashMap<>();
		
		for (Parcela parcela : parcelas) {
			if (!parcelasPorVencimento1.containsKey(parcela.getVencimento())) {
				parcelasPorVencimento1.put(parcela.getVencimento(), new ArrayList<>());
			}
			parcelasPorVencimento1.get(parcela.getVencimento()).add(parcela);
		}
		return parcelasPorVencimento1;
	}

	public static Map<LocalDate, List<Parcela>> agrupar(List<Parcela> parcelas) {
		return null;
		
		
	}
}
