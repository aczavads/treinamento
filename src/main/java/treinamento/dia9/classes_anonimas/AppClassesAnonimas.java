package treinamento.dia9.classes_anonimas;

import java.util.Arrays;
import java.util.function.Consumer;

public class AppClassesAnonimas {
	
	
	public static void main(String[] args) {
		Consumer<String> consumidorDeStringsClasse = new ConsumidorDeStrings();
		
		Consumer<String> consumidorDeStringsAnonimo = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t.toUpperCase());
			}
		};
		
		Consumer<String> consumidorDeStringsLambda = (t) -> System.out.println(t.toUpperCase());
		
		consumidorDeStringsClasse.accept("classe");
		consumidorDeStringsAnonimo.accept("anônimo");
		consumidorDeStringsLambda.accept("lambda");
		
		Arrays.asList("um","dois","tres").forEach(consumidorDeStringsAnonimo);
	}

}
