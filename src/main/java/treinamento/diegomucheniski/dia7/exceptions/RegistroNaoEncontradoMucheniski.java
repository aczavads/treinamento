package treinamento.diegomucheniski.dia7.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RegistroNaoEncontradoMucheniski extends RuntimeException {
	private static final long serialVersionUID = 7024563880816870959L;

	public RegistroNaoEncontradoMucheniski(String mensagem) {
		super(mensagem);
	}

}
