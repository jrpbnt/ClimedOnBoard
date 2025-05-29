package inosystem.climed.climedonboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ResourceNoContentException extends RuntimeException {
    public ResourceNoContentException(String message) {
        super(message);
    }
}
