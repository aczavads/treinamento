package treinamento.guilhermeperes.dia7.base.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NotFoundedException.class)
	public ResponseEntity<NotFoundedException> handleNotFounded(NotFoundedException exception) {
		return ResponseEntity.status(exception.getStatus()).body(exception);
	}
}
