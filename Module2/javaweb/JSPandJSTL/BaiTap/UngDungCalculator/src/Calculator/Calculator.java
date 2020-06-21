package Calculator;

public class Calculator {
    public static float calculator(float firstOperand, float secondOperand, String operator ){
        switch (operator){
            case "add":
                return firstOperand + secondOperand;
            case "sub":
                return firstOperand - secondOperand;
            case "mul":
                return firstOperand * secondOperand;
            case "div":
                if(secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
