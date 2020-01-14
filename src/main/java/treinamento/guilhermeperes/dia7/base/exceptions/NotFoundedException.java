package treinamento.guilhermeperes.dia7.base.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundedException extends BaseException {
	
	private static final long serialVersionUID = 1L;

	public NotFoundedException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}
}
