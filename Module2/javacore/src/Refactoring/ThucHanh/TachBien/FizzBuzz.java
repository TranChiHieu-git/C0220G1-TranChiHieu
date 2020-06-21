package Refactoring.ThucHanh.TachBien;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        if (isFizz && isBuzz)
            return "FizzBuzz";

        if (isFizz)
            return "Fizz";

        if (isBuzz)
            return "Buzz";

        return number + "";
    }
    void testFizz3() {
        int number = 3;
        String result = fizzBuzz(number);
        System.out.println(result);
    }

    void testFizz6() {
        int number = 6;
        String result = fizzBuzz(number);
        System.out.println(result);
    }

    void testBuzz5() {
        int number = 5;
        String result = fizzBuzz(number);
        System.out.println(result);
    }

    void testBuzz10() {
        int number = 10;
        String result = fizzBuzz(number);
        System.out.println(result);
    }

    void testFizzBuzz15() {
        int number = 15;
        String result = fizzBuzz(number);
        System.out.println(result);
    }

    void testFizzBuzz30() {
        int number = 30;
        String result = fizzBuzz(number);
        System.out.println(result);
    }


    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.testBuzz5();
        fizzBuzz.testBuzz10();
        fizzBuzz.testFizz3();
        fizzBuzz.testFizz6();
        fizzBuzz.testFizzBuzz15();
        fizzBuzz.testFizzBuzz30();
    }
}
