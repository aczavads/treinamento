package thais.matera.dia7.conta_contabil;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RegistroExistente extends RuntimeException {
	public RegistroExistente(String message) {
		super(message);
	}
}
