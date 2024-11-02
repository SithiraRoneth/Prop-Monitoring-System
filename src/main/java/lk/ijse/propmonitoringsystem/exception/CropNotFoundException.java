package lk.ijse.propmonitoringsystem.exception;

public class CropNotFoundException extends RuntimeException {
    public CropNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CropNotFoundException() {
        super();
    }

    public CropNotFoundException(String message) {
        super(message);
    }
}
