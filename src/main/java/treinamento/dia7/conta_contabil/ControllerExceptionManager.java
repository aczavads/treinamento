package treinamento.dia7.conta_contabil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import schiavon.gabriel.dia7.conta_contabil.BaseController;

@ControllerAdvice(assignableTypes = {BaseController.class})
public class ControllerExceptionManager {
	private final Logger logger = LoggerFactory.getLogger(ControllerExceptionManager.class);
	
	@ExceptionHandler({IllegalArgumentException.class})
	public ResponseEntity<Void> illegalArgument(IllegalArgumentException ex) {
		logger.warn("Erro de argumentos.", ex);
		return ResponseEntity.notFound().build();
	}

}
