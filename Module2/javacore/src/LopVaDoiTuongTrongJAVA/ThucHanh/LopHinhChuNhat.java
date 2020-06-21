package LopVaDoiTuongTrongJAVA.ThucHanh;

import java.util.Scanner;

public class LopHinhChuNhat {
    public static class Retangle {
        private double width, height;

        Retangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getArea() {
            return this.width * this.height;
        }

        public double getPerimeter() {
            return (this.width + this.height) * 2;
        }

        public String display() {
            return "Hinh chu nhat co canh " + this.width + " x " + this.height + " co dien tich la: " + this.getArea() + " co chu vi la: " + this.getPerimeter();
        }
    }

    public static void main(String[] args) {
        Retangle retangle1 = new Retangle(10, 5);
        Retangle retangle2 = new Retangle(10, 5);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao chieu rong: ");
        double width = scanner.nextDouble();
        System.out.print("Nhap vao chieu cao: ");
        double height = scanner.nextDouble();
        Retangle hinhchunhat = new Retangle(width, height);
        System.out.print(hinhchunhat.display());
    }
}
