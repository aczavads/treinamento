package treinamento.thyagofranco.dia2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppCollections {
	
	public static void main(String[] args) {
		
		List<String> listaDeNomes = new ArrayList<>();
		Set<String> conjuntoDeNomes = new HashSet<>();
		
		listaDeNomes.add("Ana");
		listaDeNomes.add("Ana");
		listaDeNomes.add("Ana");
		listaDeNomes.add("Ana");
		listaDeNomes.add("Ana");
		//listaDeNomes.add(BigDecimal.TEN);
		

		conjuntoDeNomes.add("Josias");
		conjuntoDeNomes.add("Josias");
		conjuntoDeNomes.add("Josias");
		conjuntoDeNomes.add("Josias");
		conjuntoDeNomes.add("Josias");
		//conjuntoDeNomes.add(BigDecimal.TEN);
		
		listar(listaDeNomes);
		listar(conjuntoDeNomes);
		
	}
	private static void listar(Collection<String> coleção) {
		System.out.println("======================");
//		for (String object : coleção) {
//			System.out.println(object.toUpperCase());
//		}
		coleção.forEach(System.out::println);
	}

}
