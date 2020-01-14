package schiavon.gabriel.dia7.conta_contabil.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RegistroNaoEncontrado extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RegistroNaoEncontrado(String mensagem) {
		super(mensagem);
	}
}
