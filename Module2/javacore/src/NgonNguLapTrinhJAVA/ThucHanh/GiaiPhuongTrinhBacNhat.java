package NgonNguLapTrinhJAVA.ThucHanh;

import java.util.Scanner;

public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao a: ");
        float a = scanner.nextFloat();
        System.out.print("Nhap vao b: ");
        float b = scanner.nextFloat();
        if (a == 0) {
            if (b != 0) {
                System.out.print("Phuong trinh vo nghiem");
            } else {
                System.out.print("Phuong trinh co vo so nghiem");
            }
        } else {
            float x = (-b / a);
            System.out.print("Phuong trinh co nghiem la: x = " + x);
        }
    }
}
