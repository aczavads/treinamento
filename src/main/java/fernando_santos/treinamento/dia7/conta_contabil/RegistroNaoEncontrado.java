package fernando_santos.treinamento.dia7.conta_contabil;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RegistroNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 6168712150094424898L;

	public RegistroNaoEncontrado(String message) {
		super(message);
	}

}
