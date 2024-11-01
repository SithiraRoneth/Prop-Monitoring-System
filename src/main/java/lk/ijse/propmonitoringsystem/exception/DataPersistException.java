package lk.ijse.propmonitoringsystem.exception;

public class DataPersistException extends RuntimeException {
    public DataPersistException(String message) {
        super(message);
    }
    public DataPersistException() {
        super();
    }

    public DataPersistException(String message, Throwable cause) {
        super(message, cause);
    }
}
