package lk.ijse.propmonitoringsystem.exception;

public class FieldNotFoundException extends RuntimeException {
    public FieldNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FieldNotFoundException() {
        super();
    }

    public FieldNotFoundException(String message) {
        super(message);
    }
}
