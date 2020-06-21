package NgonNguLapTrinhJAVA.ThucHanh;

import java.util.Scanner;

public class ThietKeMENUChoUngDung {
    public static void main(String[] args) {
        System.out.println("Menu");
        System.out.println("1. Draw the triangle");
        System.out.println("2. Draw the square");
        System.out.println("3. Draw the rectangle");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("**********");
                System.out.println("********");
                System.out.println("******");
                System.out.println("****");
                System.out.println("**");
                System.out.println("*");
                break;
            case 2:
                System.out.println("**********");
                System.out.println("**********");
                System.out.println("**********");
                System.out.println("**********");
                System.out.println("**********");
                System.out.println("**********");
                break;
            case 3:
                System.out.println("*");
                System.out.println("**");
                System.out.println("****");
                System.out.println("******");
                System.out.println("********");
                System.out.println("************");
                break;
            case 0:
                break;
        }
    }
}
