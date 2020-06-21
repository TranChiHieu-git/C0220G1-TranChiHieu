package CaseStudy.FuramaResort.CustomerException;

public class IdCardException extends Exception {
    private String message;

    public IdCardException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
