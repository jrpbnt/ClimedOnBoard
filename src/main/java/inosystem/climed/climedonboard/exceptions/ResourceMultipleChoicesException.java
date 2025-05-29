package inosystem.climed.climedonboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.MULTIPLE_CHOICES)
public class ResourceMultipleChoicesException extends RuntimeException {
    public ResourceMultipleChoicesException(String message) {
        super(message);
    }
}
