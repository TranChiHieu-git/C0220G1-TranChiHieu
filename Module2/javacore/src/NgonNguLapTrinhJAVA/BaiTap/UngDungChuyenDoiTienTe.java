package NgonNguLapTrinhJAVA.BaiTap;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao USD: ");
        double USD = scanner.nextInt();
        double VND = USD*23000;
        System.out.println(VND+" VND");
    }
}
