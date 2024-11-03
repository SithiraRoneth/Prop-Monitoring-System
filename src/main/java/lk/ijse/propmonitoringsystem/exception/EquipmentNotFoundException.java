package lk.ijse.propmonitoringsystem.exception;

public class EquipmentNotFoundException extends RuntimeException {
    public EquipmentNotFoundException(String message) {
        super(message);
    }
    public EquipmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public EquipmentNotFoundException() {}
}
