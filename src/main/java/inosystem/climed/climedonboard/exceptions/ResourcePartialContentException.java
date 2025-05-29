package inosystem.climed.climedonboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PARTIAL_CONTENT)
public class ResourcePartialContentException extends RuntimeException {
    public ResourcePartialContentException(String message) {
        super(message);
    }
}