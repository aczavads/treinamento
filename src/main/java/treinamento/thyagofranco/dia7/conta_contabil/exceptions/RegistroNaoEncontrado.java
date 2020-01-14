package treinamento.thyagofranco.dia7.conta_contabil.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RegistroNaoEncontrado extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1696679706721682153L;

	public RegistroNaoEncontrado(String message) {
		super(message);
	}
	

}
