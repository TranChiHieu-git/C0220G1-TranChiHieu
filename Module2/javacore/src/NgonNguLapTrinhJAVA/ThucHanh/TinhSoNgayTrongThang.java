package NgonNguLapTrinhJAVA.ThucHanh;

import java.util.Scanner;

public class TinhSoNgayTrongThang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao thang muon tinh so ngay: ");
        int month = scanner.nextInt();
        switch (month) {
            case 2:
                System.out.printf("Thang %d co 28 hoac 29 ngay", month);
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.printf("Thang %d co 31 ngay", month);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.printf("Thang %d co 30 ngay", month);
                break;
        }
    }
}
