import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vao so can chuyen: ");
        String num = input.nextLine();
        switch (num.length()) {
            case 1:
                switch (num) {
                    case "0":
                        System.out.print("Zero");
                        break;
                    case "1":
                        System.out.print("One");
                        break;
                    case "2":
                        System.out.print("Two");
                        break;
                    case "3":
                        System.out.print("Three");
                        break;
                    case "4":
                        System.out.print("Four");
                        break;
                    case "5":
                        System.out.print("Five");
                        break;
                    case "6":
                        System.out.print("Six");
                        break;
                    case "7":
                        System.out.print("Seven");
                        break;
                    case "8":
                        System.out.print("Eight");
                        break;
                    case "9":
                        System.out.print("Nine");
                        break;
                }
                break;
            case 2:
                if (num.charAt(0) == '1') {
                    switch (num.charAt(1)) {
                        case '0':
                            System.out.print("Ten");
                            break;
                        case '1':
                            System.out.print("Eleven");
                            break;
                        case '2':
                            System.out.print("Twelve");
                            break;
                        case '3':
                            System.out.print("Thirteen");
                            break;
                        case '4':
                            System.out.print("Fourteen");
                            break;
                        case '5':
                            System.out.print("Fifteen");
                            break;
                        case '6':
                            System.out.print("Sixteen");
                            break;
                        case '7':
                            System.out.print("Seventeen");
                            break;
                        case '8':
                            System.out.print("Eighteen");
                            break;
                        case '9':
                            System.out.print("Nineteen");
                            break;
                    }
                } else if (num.charAt(1) == '0') {
                    switch (num.charAt(0)) {
                        case '2':
                            System.out.print("Twenty");
                            break;
                        case '3':
                            System.out.print("Thirty");
                            break;
                        case '4':
                            System.out.print("Forty");
                            break;
                        case '5':
                            System.out.print("Fifty");
                            break;
                        case '6':
                            System.out.print("Sixty");
                            break;
                        case '7':
                            System.out.print("Seventy");
                            break;
                        case '8':
                            System.out.print("Eighty");
                            break;
                        case '9':
                            System.out.print("Ninety");
                            break;
                    }
                } else if (num.charAt(0) != '0' && num.charAt(1) != '0') {
                    String num1 = "", num2 = "";
                    switch (num.charAt(0)) {
                        case '2':
                            num1 = "Twenty";
                            break;
                        case '3':
                            num1 = "Thirty";
                            break;
                        case '4':
                            num1 = "Forty";
                            break;
                        case '5':
                            num1 = "Fifty";
                            break;
                        case '6':
                            num1 = "Sixty";
                            break;
                        case '7':
                            num1 = "Seventy";
                            break;
                        case '8':
                            num1 = "Eighty";
                            break;
                        case '9':
                            num1 = "Ninety";
                            break;
                    }
                    switch (num.charAt(1)) {
                        case '1':
                            num2 = "one";
                            break;
                        case '2':
                            num2 = "two";
                            break;
                        case '3':
                            num2 = "three";
                            break;
                        case '4':
                            num2 = "four";
                            break;
                        case '5':
                            num2 = "five";
                            break;
                        case '6':
                            num2 = "six";
                            break;
                        case '7':
                            num2 = "seven";
                            break;
                        case '8':
                            num2 = "eight";
                            break;
                        case '9':
                            num2 = "nine";
                            break;
                    }
                    System.out.print(num1 + "-" + num2);
                }
                break;
            case 3:
                String num1 = "", num2 = "", num3 = "";
                switch (num.charAt(0)) {
                    case '1':
                        num1 = "One hundered";
                        break;
                    case '2':
                        num1 = "Two hundered";
                        break;
                    case '3':
                        num1 = "Three hundered";
                        break;
                    case '4':
                        num1 = "Four hundered";
                        break;
                    case '5':
                        num1 = "Five hundered";
                        break;
                    case '6':
                        num1 = "Six hundered";
                        break;
                    case '7':
                        num1 = "Seven hundered";
                        break;
                    case '8':
                        num1 = "Eight hundered";
                        break;
                    case '9':
                        num1 = "Nine hundered";
                        break;
                }
                if (num.charAt(1) != '1') {
                    switch (num.charAt(1)) {
                        case '2':
                            num2 = "Twenty";
                            break;
                        case '3':
                            num2 = "Thirty";
                            break;
                        case '4':
                            num2 = "Forty";
                            break;
                        case '5':
                            num2 = "Fifty";
                            break;
                        case '6':
                            num2 = "Sixty";
                            break;
                        case '7':
                            num2 = "Seventy";
                            break;
                        case '8':
                            num2 = "Eighty";
                            break;
                        case '9':
                            num2 = "Ninety";
                            break;
                    }
                    switch (num.charAt(2)) {
                        case '1':
                            num3 = "one";
                            break;
                        case '2':
                            num3 = "two";
                            break;
                        case '3':
                            num3 = "three";
                            break;
                        case '4':
                            num3 = "four";
                            break;
                        case '5':
                            num3 = "five";
                            break;
                        case '6':
                            num3 = "six";
                            break;
                        case '7':
                            num3 = "seven";
                            break;
                        case '8':
                            num3 = "eight";
                            break;
                        case '9':
                            num3 = "nine";
                            break;
                    }
                } else {
                    switch (num.charAt(2)) {
                        case '0':
                            num3 = "Ten";
                            break;
                        case '1':
                            num3 = "Eleven";
                            break;
                        case '2':
                            num3 = "Twelve";
                            break;
                        case '3':
                            num3 = "Thirteen";
                            break;
                        case '4':
                            num3 = "Fourteen";
                            break;
                        case '5':
                            num3 = "Fifteen";
                            break;
                        case '6':
                            num3 = "Sixteen";
                            break;
                        case '7':
                            num3 = "Seventeen";
                            break;
                        case '8':
                            num3 = "Eighteen";
                            break;
                        case '9':
                            num3 = "Nineteen";
                            break;
                    }
                }
                System.out.print(num1 + " " + num2 + " " + num3);
                break;
            default:
                System.out.print("out of ability");
        }
    }
}
