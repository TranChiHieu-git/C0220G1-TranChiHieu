import java.util.Scanner;

public class SuDungToanTu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao chieu rong: ");
        float width = scanner.nextFloat();
        System.out.print("Nhap vao chieu rong: ");
        float height = scanner.nextFloat();
        float resuilt = width * height;
        System.out.print("Dien tich hinh chu nhat la: " + resuilt + " M2");
    }
}
