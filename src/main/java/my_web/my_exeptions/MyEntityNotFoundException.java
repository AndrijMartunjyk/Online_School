package my_web.my_exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyEntityNotFoundException extends RuntimeException {
    public MyEntityNotFoundException(List<Long> id) {
        super("Entity is not found, id="+id);
    }
}
