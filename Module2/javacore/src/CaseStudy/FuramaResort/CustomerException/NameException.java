package CaseStudy.FuramaResort.CustomerException;

public class NameException  extends  Exception{
private String message;

    public NameException(String message) {
        super(message);
        this.message = message;
    }
    @Override
    public String getMessage(){
        return this.message;
    }
}
