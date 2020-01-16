package schiavon.gabriel.dia7.conta_contabil.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionManager {

	private final Logger logger = LoggerFactory.getLogger(MyExceptionManager.class);
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Void> illegalArgument(IllegalArgumentException ex) {
		logger.warn("Erro de argumentos.", ex);
		return ResponseEntity
				.notFound()
				.build();
	}
}
