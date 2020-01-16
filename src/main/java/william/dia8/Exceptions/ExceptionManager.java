package william.dia8.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

	private final Logger logger = LoggerFactory.getLogger(ExceptionManager.class);
	
	@ExceptionHandler({IllegalArgumentException.class})
	public ResponseEntity<Void> illegalArgument(IllegalArgumentException ex){
		logger.warn("Argumento inválido", ex);
		return ResponseEntity.notFound().build();
	}
}
