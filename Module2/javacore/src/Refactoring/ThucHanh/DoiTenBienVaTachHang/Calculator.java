package Refactoring.ThucHanh.DoiTenBienVaTachHang;

public class Calculator {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';

    public static int calculate(int firstOperand, int secondOperand, char operator) {
        switch (operator) {
            case ADDITION:
                return firstOperand + secondOperand;
            case SUBTRACTION:
                return firstOperand - secondOperand;
            case MULTIPLICATION:
                return firstOperand * secondOperand;
            case DIVISION:
                if (secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }


    void testCalculateAdd() {
        int firstOperand = 1;
        int secondOperand = 1;
        char operator = '+';
        int result = calculate(firstOperand, secondOperand, operator);
        System.out.println(result);
    }

    void testCalculateSub() {
        int a = 2;
        int b = 1;
        char o = '-';
        int result = calculate(a, b, o);
        System.out.println(result);
    }

    void testCalculateMul() {
        int a = 2;
        int b = 2;
        char o = '*';
        int result = calculate(a, b, o);
        System.out.println(result);
    }

    void testCalculateDiv() {
        int firstOperand = 6;
        int secondOperand = 3;
        char operator = '/';
        int result = calculate(firstOperand, secondOperand, operator);
        System.out.println(result);
    }

    void testCalculateDivByZero() {
        int a = 2;
        int b = 0;
        char o = '/';
        int resuilt = calculate(a, b, o);
        System.out.println(resuilt);
    }

    void testCalculateWrongOperator() {
        int a = 2;
        int b = 0;
        char o = '=';
        int resuilt = calculate(a, b, o);
        System.out.println(resuilt);
    }


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.testCalculateAdd();
        calculator.testCalculateDiv();
        calculator.testCalculateMul();
        calculator.testCalculateSub();
        calculator.testCalculateDivByZero();
        calculator.testCalculateWrongOperator();

    }
}