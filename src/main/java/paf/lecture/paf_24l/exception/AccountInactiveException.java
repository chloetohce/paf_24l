package paf.lecture.paf_24l.exception;

public class AccountInactiveException extends RuntimeException {

    public AccountInactiveException() {
    }

    public AccountInactiveException(String message) {
        super(message);
    }

    public AccountInactiveException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
