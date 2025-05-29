package inosystem.climed.climedonboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SEE_OTHER)
public class ResourceRedirectException extends RuntimeException {
    public ResourceRedirectException(String message) {
        super(message);
    }
}
