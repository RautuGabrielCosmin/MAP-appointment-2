package repo;

public class ExceptionRepository extends RuntimeException {
    public ExceptionRepository(String message) {
        super(message);
    }
}
