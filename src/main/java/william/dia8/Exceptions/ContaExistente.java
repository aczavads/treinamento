package william.dia8.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ContaExistente extends RuntimeException {

	public ContaExistente(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
