package treinamento.guilhermeperes.dia7.base.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"cause", "localizedMessage", "stackTrace", "suppressed"})
public class BaseException extends RuntimeException {
	
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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getError() {
		return error;
	}
}
