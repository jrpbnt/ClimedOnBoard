package inosystem.climed.climedonboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
public class ResourceTemporaryRedirectException extends RuntimeException {
    public ResourceTemporaryRedirectException(String message) {
        super(message);
    }
}
