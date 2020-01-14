package william.silva.dia6.Livro;

import org.springframework.stereotype.Component;

//@Component
public class MeuLogger {

	public void Log(String message) {
		System.out.println("[[MEULOGGER]]" + message);
	}
}
