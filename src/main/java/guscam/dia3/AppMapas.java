package guscam.dia3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppMapas {

	public static void main(String[] args) {
		Map<String, List<Long>> mapa = new HashMap<>();
		
		mapa.put("PR", new ArrayList<Long>());			
		mapa.put("AC", new ArrayList<Long>());			
		mapa.put("SC", new ArrayList<Long>());			

		mapa.get("PR").add(100L);
		mapa.get("PR").add(100L);
		mapa.get("PR").add(100L);

		mapa.get("PR").remove(0);
		
		
	}

}
