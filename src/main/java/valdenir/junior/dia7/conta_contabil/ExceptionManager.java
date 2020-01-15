package valdenir.junior.dia7.conta_contabil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

	private final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<Void> handlerIllegalArgumentException(IllegalArgumentException ex) {
		logger.warn("erro ", ex);
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(value = NumeroInvalidoException.class)
	public ResponseEntity<Void> handlerNumeroInvalidoException(NumeroInvalidoException ex) {
		logger.warn("erro ", ex);
		return ResponseEntity.badRequest().build();
	}
}
