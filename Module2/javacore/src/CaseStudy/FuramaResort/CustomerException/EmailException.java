package CaseStudy.FuramaResort.CustomerException;

public class EmailException extends Exception {
    private String message;

    public EmailException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
