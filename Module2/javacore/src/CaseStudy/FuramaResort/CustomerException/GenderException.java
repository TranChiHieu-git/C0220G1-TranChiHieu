package CaseStudy.FuramaResort.CustomerException;

public class GenderException extends Exception {
    private String message;

    public GenderException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
