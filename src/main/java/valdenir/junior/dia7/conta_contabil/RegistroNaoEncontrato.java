package valdenir.junior.dia7.conta_contabil;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RegistroNaoEncontrato extends RuntimeException {

	private static final long serialVersionUID = 6656112536823487720L;

	public RegistroNaoEncontrato(String message) {
		super(message);
	}
}
