package treinamento.dia6.fernando.santos;

import org.springframework.stereotype.Component;

//@Component
public class MeuLoggerFS {
	
	public void log(String message) {
		System.out.println("[[MeuLogger]] " + message);
	}

}
