package thais.matera.dia7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import thais.matera.dia7.conta_contabil.BaseController;
import thais.matera.dia7.conta_contabil.RegistroNaoEncontrado;

@ControllerAdvice(assignableTypes = {BaseController.class})
public class ExceptionManager {
	private final Logger logger = LoggerFactory.getLogger(ExceptionManager.class);
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Void> illegalArgument(IllegalArgumentException ex) {
		logger.warn("Erro de argumentos ", ex);
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler({RegistroNaoEncontrado.class})
	public ResponseEntity<Void> registroNaoEncontrado(RegistroNaoEncontrado ex) {
		logger.warn("Regitro n�o entrotrado " + ex);
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler({DataIntegrityViolationException.class})
	public ResponseEntity<Void> x(DataIntegrityViolationException ex) {
		logger.warn("");
		return ResponseEntity.notFound().build();
	}
}
