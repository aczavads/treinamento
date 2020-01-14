package treinamento.dia7.conta_contabil2.fernando.santos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RegistroNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = -4666552778314784101L;

	public RegistroNaoEncontrado(String message) {
		super(message);
	}

}
