package online_school.exception;

public class EntityNotFoundException extends IllegalArgumentException {
    public EntityNotFoundException(String s) {
        super(s);
    }
}
