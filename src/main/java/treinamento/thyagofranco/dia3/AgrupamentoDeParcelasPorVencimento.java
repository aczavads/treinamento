
package treinamento.thyagofranco.dia3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import treinamento.dia2.ParcelamentoComParcela;
import treinamento.dia2.Parcela;

/*
criar uma lista com 100 parcelas geradas de 10 em 10 
Database iniciando 08/01
30 dias de prazo
Colocar todas estas parcelas em uma mesma lista 
Processar esta lista para retornar um Map<LocalDate, List<Parcela>>
consolidarPorVencimento() 

 */

public class AgrupamentoDeParcelasPorVencimento {
	
	private static LocalDate dataBase = LocalDate.of(2020, 1, 8);	
	private static int prazoEmDias = 30;
	private static BigDecimal valorBase = new BigDecimal("1500.00");
	private static int quantidadeDeParcelas = 10;
	
	public static void main(String[] args) {
	
		List<Parcela> parcelas = criarCemParcelas(valorBase, dataBase, prazoEmDias);
		Map<LocalDate, List<Parcela>> parcelarPorVencimento = agrupar(parcelas);
		imprimirParcelasPorVencimentoNoConsole(parcelarPorVencimento);
		
	}
	
	private static List<Parcela> criarCemParcelas(BigDecimal valorBase, LocalDate dataBase, int prazoEmDias) {
		List<Parcela> parcelas = new ArrayList<>();
		
		for(int i = 0; i < 10; i++ ) {
			parcelas.addAll(
					ParcelamentoComParcela.parcelar(valorBase.multiply(new BigDecimal(i+1)), quantidadeDeParcelas, dataBase, prazoEmDias));
		}
		
		//imprimirParcelas(parcelas);
		System.out.println("Total de parcelas: " + parcelas.size());
		return parcelas;
	}
	
	private static void imprimirParcelasPorVencimentoNoConsole(Map<LocalDate, List<Parcela>> parcelarPorVencimento) {
		for(Entry<LocalDate, List<Parcela>> entry : parcelarPorVencimento.entrySet()) {
			System.out.println(entry.getKey());
			for (Parcela parcela : entry.getValue()) {
				System.out.println(" " + parcela);
			}
		}
		
	}


	public static Map<LocalDate, List<Parcela>> agrupar(List<Parcela> parcelas) {
		
		Map<LocalDate, List<Parcela>> parcelasPorVencimento = new HashMap<>();
	
		for (Parcela parcela : parcelas) {
			if(!parcelasPorVencimento.containsKey(parcela.getVencimento())) {
				parcelasPorVencimento.put(parcela.getVencimento(), new ArrayList<>());		
			}
			parcelasPorVencimento.get(parcela.getVencimento()).add(parcela);
		}
		
		return parcelasPorVencimento;
	}
	
	private static void imprimirParcelas(List<Parcela> parcelas) {
		for (Parcela parcela : parcelas) {
			System.out.println(parcela);
		}
	}
}
