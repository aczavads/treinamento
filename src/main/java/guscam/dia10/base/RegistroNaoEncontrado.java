package guscam.dia10.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RegistroNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = -4666552778314784101L;

	public RegistroNaoEncontrado(String message) {
		super(message);
	}

}
