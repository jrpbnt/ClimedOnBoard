package inosystem.climed.climedonboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ResourceUpdateNoContentException extends RuntimeException {
    public ResourceUpdateNoContentException(String message) {
        super(message);
    }
}
