package william.dia8.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ContaNãoEncontrada extends RuntimeException{

	public ContaNãoEncontrada(String message) {
		super(message);
	}
	
}
