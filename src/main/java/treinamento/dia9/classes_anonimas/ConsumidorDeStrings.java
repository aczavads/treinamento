package treinamento.dia9.classes_anonimas;

import java.util.function.Consumer;

public class ConsumidorDeStrings implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t.toUpperCase());
	}

}
