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

		ConsumidorDeStrings cs = new ConsumidorDeStrings();
		Consumer<String> consumidorDeStringsMetodoNaoEstatico = cs::accept;
		
		Consumer<String> consumidorDeStringsMetodoEstatico = AppClassesAnonimas::meuUpperCase;

		consumidorDeStringsClasse.accept("classe");
		consumidorDeStringsAnonimo.accept("an�nimo");
		consumidorDeStringsLambda.accept("lambda");
		consumidorDeStringsMetodoEstatico.accept("m�todo est�tico");
		consumidorDeStringsMetodoNaoEstatico.accept("m�todo n�o est�tico");
		
		//Arrays.asList("um","dois","tres").forEach(consumidorDeStringsAnonimo);
	}
	
	public static void meuUpperCase(String s) {
		System.out.println(s.toUpperCase());
	}

}




