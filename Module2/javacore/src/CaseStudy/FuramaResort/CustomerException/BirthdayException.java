package CaseStudy.FuramaResort.CustomerException;

public class BirthdayException extends Exception {
    private String message;

    public BirthdayException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
