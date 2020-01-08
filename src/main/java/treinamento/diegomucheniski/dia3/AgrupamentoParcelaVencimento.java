package treinamento.diegomucheniski.dia3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import treinamento.dia2.Parcela;
import treinamento.dia2.ParcelamentoComParcela;

/*
 1. Criar uma lista com 100 parcelas geradas de 10 em 10
 2. Data base iniciando em 08/01/2020
 3. 30 dias de prazo
 4. Colocar todas estas parcelas em uma mesma lista
 5. Processar esta lista para retornar um Map<LocalDate, List<Parcela>> no qual as parcelas estarão agrupadas conforme sua data de vencimento. 
 */

public class AgrupamentoParcelaVencimento {	
	
	private static LocalDate dataBase = LocalDate.of(2020, 1, 8);
	private static int prazoEmDias = 30;	
	private static BigDecimal valorBaseParcelar = new BigDecimal("1500.00");
	private static int quantidadeParcelas = 10;
	
	public static void main(String[] args) {			
		List<Parcela> parcelas = criarCemParcelas(dataBase, prazoEmDias);		
		Map<LocalDate, List<Parcela>> parcelasPorVencimento = agrupar(parcelas);
		imprimirParcelasPorVencimento(parcelasPorVencimento);
	}

	private static List<Parcela> criarCemParcelas(LocalDate dataBase, int prazoEmDias) {
		List<Parcela> parcelas = new ArrayList<>();
		for (int i = 0; i < 10; i++) {			
			parcelas.addAll(ParcelamentoComParcela.parcelar(valorBaseParcelar.multiply(new BigDecimal(i+1)), quantidadeParcelas, dataBase, prazoEmDias));			
		}		
		// imprimirParcelas(parcelas);
		System.out.println("Total parcelas: " + parcelas.size());
		return parcelas;
	}
	
	// Agrupa as parcelas por Data de vencimento
	public static Map<LocalDate, List<Parcela>> agrupar(List<Parcela> parcelas) {		
		Map<LocalDate, List<Parcela>> mapaParcelas = new HashMap<>();		
		for (Parcela parcela : parcelas) {			
			if (!mapaParcelas.containsKey(parcela.getVencimento())) {
				mapaParcelas.put(parcela.getVencimento(), new ArrayList<>());
			}
			mapaParcelas.get(parcela.getVencimento()).add(parcela);
		}		
		return mapaParcelas;
	}
	
	private static void imprimirParcelasPorVencimento(Map<LocalDate, List<Parcela>> parcelasPorVencimento) {
		for (Entry<LocalDate, List<Parcela>> entry : parcelasPorVencimento.entrySet()) {
			System.out.println("Data da parcela " + entry.getKey());
			for (Parcela parcela : entry.getValue()) {
				System.out.println("Parcela: " + parcela);
			}
		}
	}

	private static void imprimirParcelas(List<Parcela> parcelas) {		
		for (Parcela parcela : parcelas) {
			System.out.println(parcela);
		}		
	}

}
