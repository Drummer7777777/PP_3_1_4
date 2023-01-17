package ivan.vitsin.springsecurity_js_rest.Exceptions;

public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException(String message) {
        super(message);
    }
}
