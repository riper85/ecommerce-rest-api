package ro.bogdancoseru.ecommercerestapi.exception;

import ro.bogdancoseru.ecommercerestapi.exception.abstracts.AlreadyExistsException;

public class ProductAlreadyExistsException extends AlreadyExistsException {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
