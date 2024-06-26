package js_rest.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler
        public ResponseEntity<ExceptionMain> handlerException(NoSuchUserException exception) {
            ExceptionMain data = new ExceptionMain();
            data.setInfo(exception.getMessage());
            return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);

        }

        @ExceptionHandler
        public ResponseEntity<ExceptionMain> handlerException(Exception exception) {
            ExceptionMain data = new ExceptionMain();
            data.setInfo(exception.getMessage());
            return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);

        }
}
