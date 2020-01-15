package thais.matera.dia7.conta_contabil;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class HierarquiaInvalida extends RuntimeException {
	public HierarquiaInvalida(String message) {
		super(message);
	}
}
