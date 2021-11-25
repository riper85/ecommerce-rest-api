package ro.bogdancoseru.ecommercerestapi.exception;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.bogdancoseru.ecommercerestapi.dto.CustomErrorHolder;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<CustomErrorHolder> handleForbbiden(Exception exception,
                                                            WebRequest webRequest){
        CustomErrorHolder errorDetails = new CustomErrorHolder(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        errorDetails.setStatus(HttpStatus.FORBIDDEN.toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                "You don't have permissions to access this resource.", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({IllegalArgumentException.class, MalformedJwtException.class, ExpiredJwtException.class})
    public ResponseEntity<CustomErrorHolder> handleFilterExceptions(Exception exception,
                                                             WebRequest webRequest){
        CustomErrorHolder errorDetails = new CustomErrorHolder(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        errorDetails.setStatus(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
