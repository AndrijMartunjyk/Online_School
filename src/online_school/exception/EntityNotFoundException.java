package online_school.exception;

public class EntityNotFoundException extends IllegalArgumentException{
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String s) {
        super(s);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }
}
