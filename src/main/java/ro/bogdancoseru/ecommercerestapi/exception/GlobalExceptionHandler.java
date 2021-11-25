package ro.bogdancoseru.ecommercerestapi.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.bogdancoseru.ecommercerestapi.dto.CustomErrorHolder;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomErrorHolder errorMessage = getCustomErrorHolder(request, "Invalid JSON", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorMessage, headers, status);
    }

    @ExceptionHandler({ AccessDeniedException.class, BadCredentialsException.class })
    public ResponseEntity<CustomErrorHolder> handleAccessDeniedException(
            Exception exception, WebRequest webRequest) {

        CustomErrorHolder errorDetails = getCustomErrorHolder(webRequest, exception.getMessage(), HttpStatus.FORBIDDEN);

        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({InvalidFormatException.class, IllegalArgumentException.class, MalformedJwtException.class, ExpiredJwtException.class})
    public ResponseEntity<CustomErrorHolder> handleFilterExceptions(Exception exception,
                                                             WebRequest webRequest){
        CustomErrorHolder errorDetails = getCustomErrorHolder(webRequest, exception.getMessage(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ProductAlreadyExistsException.class)
    public ResponseEntity<CustomErrorHolder> blogNotFoundException(RuntimeException exception,
                                                   WebRequest webRequest) {
        CustomErrorHolder errorDetails = getCustomErrorHolder(webRequest, exception.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<CustomErrorHolder> handleGeneralException(Exception exception, WebRequest webRequest) {
        CustomErrorHolder errorDetails = getCustomErrorHolder(webRequest, exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    private CustomErrorHolder getCustomErrorHolder(WebRequest webRequest, String message, HttpStatus status) {
        return CustomErrorHolder
                .builder()
                .timestamp(LocalDateTime.now())
                .error(message)
                .path(webRequest.getDescription(false))
                .status(status.toString())
                .build();
    }
}
