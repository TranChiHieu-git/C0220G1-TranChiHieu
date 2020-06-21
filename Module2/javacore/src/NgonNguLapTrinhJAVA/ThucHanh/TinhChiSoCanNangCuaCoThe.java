package NgonNguLapTrinhJAVA.ThucHanh;

import java.util.Scanner;

public class TinhChiSoCanNangCuaCoThe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao can nang: ");
        double weight = scanner.nextFloat();
        System.out.print("Nhap vao chieu cao: ");
        double heigt = scanner.nextFloat();
        double bmi = weight / (Math.pow(heigt, 2));
        System.out.println(bmi);
        if (bmi >= 30) System.out.print("Obese");
        else if (bmi >= 25) System.out.print("Overweight");
        else if (bmi >= 18.5) System.out.print("Normal");
        else System.out.print("Underweight");
    }
}
