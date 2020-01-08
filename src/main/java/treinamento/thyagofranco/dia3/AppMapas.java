package treinamento.thyagofranco.dia3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AppMapas {

	public static void main(String[] args) {
		
		// mapas são Dicionários  - chave > valor
		// 
		
		Map<String, List<Long>> mapa = new HashMap<>();
		
		mapa.put("PR", new ArrayList<Long>());
		mapa.put("SC", new ArrayList<Long>());
		mapa.put("AC", new ArrayList<Long>());
		
		mapa.get("PR").add(100L);	//adicinando 100 na lista contida no mapa na chave PR
		mapa.get("PR").add(150L);
		mapa.get("AC").add(200L);
		
		//Buscando registro do Map
		for (Entry<String, List<Long>> entry : mapa.entrySet()) {
			System.out.println("Valores do " + entry.getKey());
			for (Long valor : entry.getValue()) {
				System.out.println("   " + valor);
			}
			
		}
		
		mapa.get("PR").remove(0);
		
		for (Long valor: mapa.get("PR")) {
			System.out.println(valor);
		}
		
		System.out.println("Tem SP no mapa? " + mapa.containsKey("SP"));
		
	}
	
}
