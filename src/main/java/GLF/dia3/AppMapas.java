package GLF.dia3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import treinamento.dia2.Parcela;
import treinamento.dia2.ParcelamentoComParcela;

public class AppMapas {

	public static void main(String[] args) {
		
		
		Map<String, List<Long>> mapa = new HashMap<>();
		mapa.put("PR", new ArrayList<Long>());
		mapa.put("SC", new ArrayList<Long>());
		mapa.put("AC", new ArrayList<Long>());
		
		mapa.get("PR").add(100L);
		mapa.get("PR").add(100L); // adiciona
		mapa.get("PR").remove(0); // remove
		
		
		for (Entry<String, List<Long>> entry : mapa.entrySet()) {
			System.out.println("Valores do " +entry.getKey());
			for(Long valor : entry.getValue()) {
				System.out.println("   " +valor);
			}
		}
			
		for (Long valor : mapa.get("PR")) {
			System.out.println(valor);
		}
		
		System.out.println("Tem SP no mapa ?" + mapa.containsKey("SP"));

		
		
		
		
		
		//Random
		Random random = new Random();
		int valorInicial = 1000;
		int valorFinal = 5000;
		
		Set<BigDecimal> valores = new HashSet<>();
		for (int i=0; i < 10; i++) {
			double valor = ((valorFinal - valorInicial) * random.nextFloat()) + valorInicial;
			//System.out.println(new BigDecimal(valor).setScale(2, RoundingMode.FLOOR));
			valores.add(new BigDecimal(valor));
		}
	}

}
