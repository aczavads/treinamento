package treinamento.dia3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AppMapas {
	
	
	public static void main(String[] args) {
		Map<String, List<Long>> mapa = new HashMap<>();
		
		mapa.put("PR", new ArrayList<Long>());
		mapa.put("SC", new ArrayList<Long>());
		mapa.put("AC", new ArrayList<Long>());
 		
		mapa.get("PR").add(100L);
		mapa.get("PR").add(150L);
		mapa.get("AC").add(200L);
		
		for (Entry<String, List<Long>> entry :  mapa.entrySet()) {
			System.out.println("Valores do " + entry.getKey());
			for (Long valor : entry.getValue()) {
				System.out.println("    " + valor);
			}
		}
		
		
		mapa.get("PR").remove(0);
		
		mapa.put("PR", new ArrayList<Long>());
		for (Long valor : mapa.get("PR")) {
			System.out.println(valor);
		}
		
		System.out.println("Tem SP no mapa? " + mapa.containsKey("SP"));
		
				

	}

}
