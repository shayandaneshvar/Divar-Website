package ir.ac.kntu.divar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ComingSoonException extends RuntimeException {
    public ComingSoonException() {
        super();
    }

    public ComingSoonException(String message) {
        super(message);
    }

    public ComingSoonException(String message, Throwable cause) {
        super(message, cause);
    }
}
