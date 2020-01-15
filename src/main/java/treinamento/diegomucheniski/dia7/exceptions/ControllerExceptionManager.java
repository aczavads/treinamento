package treinamento.diegomucheniski.dia7.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionManager {
	
	private final Logger logger = LoggerFactory.getLogger(ControllerExceptionManager.class);
	
	@ExceptionHandler({IllegalArgumentException.class})
	public ResponseEntity<Void> illegalArgumentException(IllegalArgumentException ex) {
		logger.warn("Erro de argumento: ", ex);
		return ResponseEntity.notFound().build();
	}

}
