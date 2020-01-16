package william.dia8.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RegistroNaoEncontrado extends RuntimeException{

	public RegistroNaoEncontrado(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
