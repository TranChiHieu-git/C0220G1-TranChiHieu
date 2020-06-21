package NgonNguLapTrinhJAVA.BaiTap;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers: ");
        String number = scanner.nextLine();
        String[] singleNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};
        String[] doubleNum = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        switch (number.length()) {
            case 1: {
                int num = Integer.parseInt(number);
                System.out.print(singleNum[num]);
                break;
            }
            case 2: {
                int num = Integer.parseInt(number);
                int n1 = Character.getNumericValue(number.charAt(0));
                int n2 = Character.getNumericValue(number.charAt(1));
                if (num < 20) {
                    System.out.print(singleNum[num]);
                } else if (num >= 20) {
                    System.out.print(doubleNum[n1 - 1] + " " + singleNum[n2]);
                }
                break;
            }
            case 3: {
                int n1 = Character.getNumericValue(number.charAt(0));
                int n2 = Character.getNumericValue(number.charAt(1));
                int n3 = Character.getNumericValue(number.charAt(2));
                if (n2 == n3 && n2 == 0) {
                    System.out.print(singleNum[n1] + " hundered");
                } else if (n2 == 0) {
                    System.out.print(singleNum[n1] + " hundered " + singleNum[n3]);
                } else if (n3 == 0) {
                    System.out.print(singleNum[n1] + " hundered " + doubleNum[n2 - 1]);
                } else {
                    System.out.print(singleNum[n1] + " hundered " + doubleNum[n2 - 1] + " " + singleNum[n3]);
                }
                break;
            }
            default:
                System.out.print("out of ability");
                break;
        }
    }
}
