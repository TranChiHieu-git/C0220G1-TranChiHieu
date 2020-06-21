package MangVaPhuongThucTrongJAVA.ThucHanh;

import java.util.Scanner;

public class ChuyenDoiNhietDo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MENU: ");
        System.out.println("\t1. Fahrenheit to Celsius");
        System.out.println("\t2. Celsius to Fahrenheit");
        System.out.println("0. Exit ");
        System.out.print("Input selector: ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                System.out.print("Input Fahreheit: ");
                double fahreheit = scanner.nextFloat();
                System.out.println("Celsius = " + fahrenheitToCelsius(fahreheit));
                break;
            case 2:
                System.out.print("Input Celsius: ");
                double celsius = scanner.nextFloat();
                System.out.println("Fahrenheit = " + celsiusToFahrenheit(celsius));
            case 0:
                System.exit(0);
                break;
        }
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32);
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5) * celsius + 32;
    }
}
