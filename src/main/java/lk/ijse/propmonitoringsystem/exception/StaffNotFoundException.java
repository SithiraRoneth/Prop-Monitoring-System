package lk.ijse.propmonitoringsystem.exception;

public class StaffNotFoundException extends RuntimeException {
    public StaffNotFoundException(String message) {
        super(message);
    }
    public StaffNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public StaffNotFoundException() {}
}
