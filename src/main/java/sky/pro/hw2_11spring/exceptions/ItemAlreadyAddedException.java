package sky.pro.hw2_11spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ItemAlreadyAddedException extends RuntimeException{

    public ItemAlreadyAddedException(String message) {
        super(message);
    }

}
