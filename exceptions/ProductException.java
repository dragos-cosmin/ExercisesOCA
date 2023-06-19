package org.example.exceptions;

/**
 * @author dragos.cosmin
 **/
public class ProductException extends Exception{
    public ProductException() {
        super();
    }

    public ProductException(String message) {
        super(message);
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
