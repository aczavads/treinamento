package treinamento.dia7.conta_contabil.fernando.fernandes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

	private final Logger logger = LoggerFactory.getLogger(ExceptionManager.class);

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Void> illegalArgument(IllegalArgumentException e) {
		logger.warn("Erro de argumentos.", e);
		return ResponseEntity.notFound().build();
	}

}
