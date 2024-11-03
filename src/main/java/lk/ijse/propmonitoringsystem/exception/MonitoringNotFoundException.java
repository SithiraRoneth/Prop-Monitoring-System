package lk.ijse.propmonitoringsystem.exception;

public class MonitoringNotFoundException extends RuntimeException {
    public MonitoringNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MonitoringNotFoundException() {
        super();
    }

    public MonitoringNotFoundException(String message) {
        super(message);
    }
}
