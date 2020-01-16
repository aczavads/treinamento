package fernando_santos.treinamento.dia6;

import org.springframework.stereotype.Component;

//@Component
public class MeuLoggerFS {
	
	public void log(String message) {
		System.out.println("[[MeuLogger]] " + message);
	}

}
