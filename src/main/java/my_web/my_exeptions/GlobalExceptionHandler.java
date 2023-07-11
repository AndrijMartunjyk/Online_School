package my_web.my_exeptions;

import net.bytebuddy.agent.VirtualMachine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MyEntityNotFoundException.class)
    public ResponseEntity productNotFoundException(MyEntityNotFoundException e) {
        return new ResponseEntity(e.getMessage(), NOT_FOUND);
    }

}

