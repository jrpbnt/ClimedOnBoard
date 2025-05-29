package inosystem.climed.climedonboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class ResourceDeleteOKException extends RuntimeException {
    public ResourceDeleteOKException(String message) {
        super(message);
    }
}
