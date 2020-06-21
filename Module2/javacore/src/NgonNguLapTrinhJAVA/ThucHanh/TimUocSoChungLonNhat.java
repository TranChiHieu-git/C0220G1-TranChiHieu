package NgonNguLapTrinhJAVA.ThucHanh;

import java.util.Scanner;

public class TimUocSoChungLonNhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vao so a: ");
        int a = input.nextInt();
        System.out.print("Nhap vao so b: ");
        int b = input.nextInt();
        if (a == 0 && b == 0) {
            System.out.println("error");
        } else if ((a == 0 || b == 0) && a != b) {
            System.out.println("UCLN cua " + a + " va " + b + " la: 0");
        } else {
            int c = a > b ? a : b;
            for (int i = c; i >= 1; i--) {
                if (a % i == 0 && b % i == 0) {
                    System.out.println("UCLN cua " + a + " va " + b + " la: " + i);
                    break;
                }
            }
        }
    }
}
