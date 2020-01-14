package treinamento.dia6;

import org.springframework.stereotype.Component;

//@Component
public class MeuLogger {
	
	public void log(String message) {
		System.out.println("[[MEULOGGER]] " + message);
	}

}
