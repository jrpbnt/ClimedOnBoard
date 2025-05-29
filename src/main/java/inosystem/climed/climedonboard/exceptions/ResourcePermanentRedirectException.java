package inosystem.climed.climedonboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PERMANENT_REDIRECT)
public class ResourcePermanentRedirectException extends RuntimeException {
    public ResourcePermanentRedirectException(String message) {
        super(message);
    }
}
