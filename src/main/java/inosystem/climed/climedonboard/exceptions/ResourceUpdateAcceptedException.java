package inosystem.climed.climedonboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class ResourceUpdateAcceptedException extends RuntimeException {
    public ResourceUpdateAcceptedException(String message) {
        super(message);
    }
}
