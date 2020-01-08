package thais.matera.dia3;

import java.util.HashMap;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import treinamento.dia2.ListaDeParcelasInvalida;
import treinamento.dia2.Parcela;
import treinamento.dia2.ParcelamentoComParcela;

public class AppMapas {
	
	public static void main(String[] args) {
		BigDecimal valor = new BigDecimal("1500.00");
		int quantidadeDeParcelas = 10;
		int prazoEmDias = 30;
		LocalDate dataBase = LocalDate.of(2020, 01, 8);
		
		List<Parcela> parcelas = criarCemParcelas(valor, quantidadeDeParcelas, prazoEmDias, dataBase);
		
		Map<LocalDate, List<Parcela>> mapa = montarMapa(parcelas);
		
		mostrarMapa(mapa);
	}
	
	public static List<Parcela> criarCemParcelas(BigDecimal valor, int quantidadeDeParcelas, int prazoEmDias, LocalDate dataBase) {
		List<Parcela> parcelas = new ArrayList<Parcela>();
		
		for(int i = 0; i < 10; i++) {
			List<Parcela> parcelasBuffer = ParcelamentoComParcela.parcelar(valor.multiply(new BigDecimal(i+1)), 
					quantidadeDeParcelas,
					dataBase,
					prazoEmDias
			);
			parcelas.addAll(parcelasBuffer);
		}
		
		return parcelas;
	}
	
	public static Map<LocalDate, List<Parcela>> montarMapa(List<Parcela> parcelas) {
		Map<LocalDate, List<Parcela>> mapa = new HashMap<>();
		
		if(parcelas == null) {
			throw new ListaDeParcelasInvalida("A lista de parcelas fornecida é nula");
		}

		for (Parcela parcela : parcelas) {
			if(!mapa.containsKey(parcela.getVencimento())) {
				mapa.put(parcela.getVencimento(), new ArrayList<>());
			}
			mapa.get(parcela.getVencimento()).add(parcela);
		}
		
		return mapa;
	}
	
	public static void mostrarMapa(Map<LocalDate, List<Parcela>> mapa) {
		for(java.util.Map.Entry<LocalDate, List<Parcela>> entry : mapa.entrySet()) {
			System.out.println(entry.getKey());
			List<Parcela> parcelasMesmoVencimento = entry.getValue();
			
			for (Parcela parcela : parcelasMesmoVencimento) {
				System.out.println("	- " + parcela.toString());
			}
		}
	}
}
