package NgonNguLapTrinhJAVA.BaiTap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu: ");
        System.out.println("\t1.Print the rectangle");
        System.out.println("\t2.Print the square triangle");
        System.out.println("\t3.Print isosceles triangle");
        System.out.println("\t4.Exit");
        System.out.print("Input selecter: ");
        int chose = scanner.nextInt();
        if (chose == 1) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        } else if (chose == 2) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i - j < 0)
                        System.out.print("* ");
                }
                System.out.println();
            }
        } else if (chose == 3) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i + j >= 5)
                        System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
}
