package inosystem.climed.climedonboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class ResourceDeleteAcceptedException extends RuntimeException {
    public ResourceDeleteAcceptedException(String message) {
        super(message);
    }
}