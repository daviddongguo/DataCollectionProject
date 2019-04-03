package io.moh.datacollection.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RowNotFoundException extends RuntimeException {

	public RowNotFoundException(String message) {
		super(message);
	}

}
