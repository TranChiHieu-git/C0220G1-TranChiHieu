package LopVaDoiTuongTrongJAVA.ThucHanh;

import java.util.Scanner;

public class LopQuadraticEquation {

    public static class QuadraticEquation {
        private double a, b, c;

        QuadraticEquation(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getA() {
            return this.a;
        }

        public double getB() {
            return this.b;
        }

        public double getC() {
            return this.c;
        }

        public double getDiscriminant() {
            return Math.pow(this.getB(), 2) - 4 * this.getA() * this.getC();
        }

        public double getRoot1() {
            return (-this.getB() + Math.sqrt(this.getDiscriminant())) / 2 * this.getA();
        }

        public double getRoot2() {
            return (-this.getB() - Math.sqrt(this.getDiscriminant())) / 2 * this.getA();
        }

        public double getRoot3() {
            return (-this.getB()) / (2 * this.getA());
        }

        public String display() {
            if (this.getDiscriminant() > 0) {
                return "X1=" + this.getRoot1() + " X2=" + this.getRoot2();
            } else if (this.getDiscriminant() == 0) {
                return "X=" + this.getRoot3();
            } else {
                return "The equation has no roots";
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhap vao b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhap vao c: ");
        double c = scanner.nextDouble();
        QuadraticEquation ptbac2 = new QuadraticEquation(a, b, c);
        System.out.print(ptbac2.display());
    }
}

