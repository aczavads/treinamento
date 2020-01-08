package treinamento.dia3.fernando.santos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppMapas {

	public static void main(String[] args) {
		Map<String, List<Long>> mapa = new HashMap<>();
		mapa.put("PR", new ArrayList<Long>());
		mapa.put("SC", new ArrayList<Long>());
		mapa.put("AC", new ArrayList<Long>());
		
		mapa.get("PR").add(100L);
		mapa.get("PR").add(100L);
		mapa.get("PR").add(100L);
		
		mapa.get("PR").remove(0);
		
		for(Long valor : mapa.get("PR")) {
			System.out.println(valor);
		}
		
		System.out.println("Tem SP no mapa? " + mapa.containsKey("SP"));
		
	}
	
	
	
	
}
