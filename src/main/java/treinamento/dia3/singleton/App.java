package treinamento.dia3.singleton;

import java.util.HashSet;
import java.util.Set;

public class App {
	
	public static void main(String[] args) {
		//Universo u1 = new Universo();
		//Universo u2 = new Universo();
		
		Universo u1 = Universo.getInstance();
		Universo u2 = Universo.getInstance();
		Set<Universo> conjunto = new HashSet<>();
		for (int i = 0; i < 1000; i++) {
			conjunto.add(Universo.getInstance());
		}
		
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(conjunto.size());
	}

}
