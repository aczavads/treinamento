package treinamento.diegomucheniski.dia3;

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
		
		// Adicionando valores pelas chaves
		mapa.get("PR").add(100L);
		mapa.get("PR").add(150L);
		mapa.get("PR").add(130L);
		mapa.get("SC").add(120L);		
		mapa.get("PR").remove(0); // Remove um valor da chave PR
		
		// Imprime só duas vezes 100 porque um foi removido
		for (Long valor : mapa.get("PR")) {
			System.out.println(valor);
		}
		
		// Verifica se possui um valor pela chave
		System.out.println("Verificar se contém a chave SP: " + mapa.containsKey("SP"));
		
		// Buscar os registros do Map
		for (Entry<String, List<Long>> entry : mapa.entrySet()) {
			System.out.println("Chave do estado ====== " + entry.getKey());
			for (Long valor : entry.getValue()) {
				System.out.println("Valor: " + valor);
			}
		}
		
	}	

}
