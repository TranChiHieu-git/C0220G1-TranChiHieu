package NgonNguLapTrinhJAVA.ThucHanh;
import java.util.Scanner;
public class KiemTraNamNhuan {
    public static void main(String[] args) {
        System.out.print("Nhap vao nam muon kiem tra: ");
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) {
            System.out.print(year + " la nam nhuan");
        } else {
            System.out.print(year + " khong phai la nam nhuan");
        }
    }
}
