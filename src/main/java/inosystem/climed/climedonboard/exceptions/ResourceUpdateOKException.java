package inosystem.climed.climedonboard.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class ResourceUpdateOKException extends RuntimeException {
    public ResourceUpdateOKException(String message) {
        super(message);
    }
}
