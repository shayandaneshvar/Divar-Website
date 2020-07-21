package ir.ac.kntu.divar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class BadInputException extends RuntimeException{
    public BadInputException() {
        super();
    }

    public BadInputException(String message) {
        super(message);
    }

    public BadInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadInputException(Throwable cause) {
        super(cause);
    }
}
