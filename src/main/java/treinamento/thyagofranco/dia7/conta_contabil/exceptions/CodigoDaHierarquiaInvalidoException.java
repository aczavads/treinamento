package treinamento.thyagofranco.dia7.conta_contabil.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CodigoDaHierarquiaInvalidoException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7847329349179274337L;

	public CodigoDaHierarquiaInvalidoException(String message) {
		super(message);
	}
	

}