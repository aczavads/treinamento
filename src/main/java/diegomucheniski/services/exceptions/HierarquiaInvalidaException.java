package diegomucheniski.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class HierarquiaInvalidaException extends RuntimeException {
	private static final long serialVersionUID = 7592050612706691460L;

	public HierarquiaInvalidaException(String mensagem) {
		super(mensagem);
	}

}
