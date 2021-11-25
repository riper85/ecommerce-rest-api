package ro.bogdancoseru.ecommercerestapi.exception.abstracts;

public abstract class AlreadyExistsException extends RuntimeException {
    private String message;
    public AlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
    public AlreadyExistsException() {
    }


}
