package treinamento.dia7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import treinamento.dia7.conta_contabil.RegistroNaoEncontrado;

@ControllerAdvice
public class ExceptionManager {
	private final Logger logger = LoggerFactory.getLogger(ExceptionManager.class);
	
	@ExceptionHandler({IllegalArgumentException.class})
	public ResponseEntity<Void> illegalArgument(IllegalArgumentException ex) {
		logger.warn("Erro de argumentos.", ex);
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler({RegistroNaoEncontrado.class, EmptyResultDataAccessException.class})
	public ResponseEntity<Void> registroNaoEncontrado(Exception ex) {
		logger.warn("Registro não encontrado.", ex);
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler({DataIntegrityViolationException.class}) 
	public ResponseEntity<Void> dataIntegrityViolationException(DataIntegrityViolationException ex) {
		logger.warn("Erro de integridade no banco de dados.", ex);
		return ResponseEntity.badRequest().build();			
	}
				
}
