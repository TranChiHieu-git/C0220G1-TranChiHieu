package MangVaPhuongThucTrongJAVA.BaiTap.SuDungLopIllegalTriangleException;

import MangVaPhuongThucTrongJAVA.BaiTap.SuDungLopIllegalTriangleException.IllegalTriangleException;

import java.util.Scanner;

public class KiemTraTamGiac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao canh thu nhat: ");
        double a = scanner.nextDouble();
        System.out.print("Nhap vao canh thu hai: ");
        double b = scanner.nextDouble();
        System.out.print("Nhap vao canh thu ba: ");
        double c = scanner.nextDouble();
        try {
            if (a <= 0 || b <= 0 || c <= 0 || a + b < c || a + c < b || b + c < a) {
                throw new IllegalTriangleException();
            } else {
                System.out.println("3 canh nhap vao la 3 canh cua mot tam giac!");
            }
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Ket thuc chuong trinh");
        }
    }
}
