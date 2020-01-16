package guscam.dia7;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {
	
	@ExceptionHandler({IllegalArgumentException.class})
	public ResponseEntity<Void> illegalArgument(IllegalArgumentException ex) {
		return ResponseEntity.notFound().build();
	}

}
