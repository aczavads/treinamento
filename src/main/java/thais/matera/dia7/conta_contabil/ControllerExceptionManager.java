package thais.matera.dia7.conta_contabil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {BaseController.class})
public class ControllerExceptionManager {
	private final Logger logger = LoggerFactory.getLogger(ControllerExceptionManager.class);
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Void> illegalArgument(IllegalArgumentException ex) {
		logger.warn("Erro de argumentos ", ex);
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler({RegistroNaoEncontrado.class})
	public ResponseEntity<Void> registroNaoEncontrado(RegistroNaoEncontrado ex) {
		logger.warn("Regitro não entrotrado " + ex);
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler({DataIntegrityViolationException.class})
	public ResponseEntity<Void> x(DataIntegrityViolationException ex) {
		logger.warn("");
		return ResponseEntity.notFound().build();
	}
}
