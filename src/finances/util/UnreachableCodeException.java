package finances.util;

public class UnreachableCodeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnreachableCodeException() {
        super("Supposedly unreachable code was executed");
    }
}
