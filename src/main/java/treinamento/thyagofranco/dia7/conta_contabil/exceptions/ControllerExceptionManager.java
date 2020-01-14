package treinamento.thyagofranco.dia7.conta_contabil.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import treinamento.thyagofranco.dia7.conta_contabil.BaseController;

@ControllerAdvice(assignableTypes = { BaseController.class })
public class ControllerExceptionManager {
	private final Logger logger = LoggerFactory.getLogger(ControllerExceptionManager.class);

	// /api/contascontabeis/zzzz passando string no lugar de UUID

	@ExceptionHandler({ IllegalArgumentException.class })
	public ResponseEntity<Void> illegalArgumentException(IllegalArgumentException ex) {
		logger.warn("Erro de argumento.", ex);
		return ResponseEntity.notFound().build();

	}

}
