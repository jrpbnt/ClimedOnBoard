package inosystem.climed.climedonboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class ResourceAcceptedException extends RuntimeException {
    public ResourceAcceptedException(String message) {
        super(message);
    }
}
