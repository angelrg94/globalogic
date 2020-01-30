package cl.globallogic.earthquake.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorException extends RuntimeException {

	public InternalErrorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
