package william.dia8.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class CodigoInvalido extends RuntimeException {

	public CodigoInvalido(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
