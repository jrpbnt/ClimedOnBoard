package inosystem.climed.climedonboard.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.NOT_FOUND, "Recurso não encontrado");
    }

    @ExceptionHandler(ResourceCreatedException.class)
    public ResponseEntity<StandardError> resourceCreated(ResourceCreatedException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.CREATED, "Recurso Criado");
    }

    @ExceptionHandler(ResourceAcceptedException.class)
    public ResponseEntity<StandardError> resourceAccepted(ResourceAcceptedException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.ACCEPTED, "Requisição Aceita");
    }

    @ExceptionHandler(ResourceRedirectException.class)
    public ResponseEntity<StandardError> resourceRedirect(ResourceRedirectException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.SEE_OTHER, "Recurso Redirecionado");
    }

    @ExceptionHandler(ResourceNoContentException.class)
    public ResponseEntity<Void> resourceNoContent(ResourceNoContentException e) {
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ResourcePartialContentException.class)
    public ResponseEntity<StandardError> resourcePartialContent(ResourcePartialContentException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.PARTIAL_CONTENT, "Conteúdo Parcial");
    }

    @ExceptionHandler(ResourceMultipleChoicesException.class)
    public ResponseEntity<StandardError> resourceMultipleChoices(ResourceMultipleChoicesException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.MULTIPLE_CHOICES, "Múltiplas Opções");
    }

    @ExceptionHandler(ResourcePermanentRedirectException.class)
    public ResponseEntity<StandardError> resourcePermanentRedirect(ResourcePermanentRedirectException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.PERMANENT_REDIRECT, "Redirecionamento Permanente");
    }

    @ExceptionHandler(ResourceNotModifiedException.class)
    public ResponseEntity<Void> resourceNotModified(ResourceNotModifiedException e) {
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @ExceptionHandler(ResourceTemporaryRedirectException.class)
    public ResponseEntity<StandardError> resourceTemporaryRedirect(ResourceTemporaryRedirectException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.TEMPORARY_REDIRECT, "Redirecionamento Temporário");
    }

    @ExceptionHandler(ResourceUpdateOKException.class)
    public ResponseEntity<StandardError> resourceUpdateOK(ResourceUpdateOKException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.OK, "Atualização bem-sucedida");
    }

    @ExceptionHandler(ResourceUpdateNoContentException.class)
    public ResponseEntity<Void> resourceUpdateNoContent(ResourceUpdateNoContentException e) {
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ResourceUpdateAcceptedException.class)
    public ResponseEntity<StandardError> resourceUpdateAccepted(ResourceUpdateAcceptedException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.ACCEPTED, "Atualização aceita");
    }

    @ExceptionHandler(ResourceDeleteOKException.class)
    public ResponseEntity<StandardError> resourceDeleteOK(ResourceDeleteOKException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.OK, "Recurso excluído com sucesso");
    }

    @ExceptionHandler(ResourceDeleteNoContentException.class)
    public ResponseEntity<Void> resourceDeleteNoContent(ResourceDeleteNoContentException e) {
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ResourceDeleteAcceptedException.class)
    public ResponseEntity<StandardError> resourceDeleteAccepted(ResourceDeleteAcceptedException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.ACCEPTED, "Exclusão aceita e em processamento");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> globalException(Exception e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor");
    }

    private ResponseEntity<StandardError> buildErrorResponse(Exception e, HttpServletRequest request, HttpStatus status, String errorTitle) {
        StandardError err = new StandardError(
                Instant.now(),
                status.value(),
                errorTitle,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<StandardError> handleValidationException(ValidationException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.UNPROCESSABLE_ENTITY, "Erro de Validação");
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> handleConstraintViolationException(
            ConstraintViolationException e, HttpServletRequest request) {
        return buildErrorResponse(e, request, HttpStatus.UNPROCESSABLE_ENTITY, "Erro de Validação");
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}

