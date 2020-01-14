package treinamento.guilhermeperes.dia7.base.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"cause", "localizedMessage", "stackTrace", "suppressed"})
public abstract class BaseException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private final LocalDateTime timestamp = LocalDateTime.now();
	private int status;
	private String message;
	private String error;

	public BaseException(HttpStatus status, String message) {
		this.status = status.value();
		this.error = status.toString();
		this.message = message;
	}
}
