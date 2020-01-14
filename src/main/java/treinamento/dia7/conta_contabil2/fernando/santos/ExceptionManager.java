package treinamento.dia7.conta_contabil2.fernando.santos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {BaseController.class})
public class ExceptionManager {
	private final Logger logger = LoggerFactory.getLogger(ExceptionManager.class);
	
	@ExceptionHandler({IllegalArgumentException.class})
	public ResponseEntity<Void> illegalArgument(IllegalArgumentException ex) {
		logger.warn("Erro de argumentos.", ex);
		return ResponseEntity.notFound().build();
	}
	
	

}
