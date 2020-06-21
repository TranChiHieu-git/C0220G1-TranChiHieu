package NgonNguLapTrinhJAVA.ThucHanh;

import java.util.Scanner;

public class UngDungTinhTienLaiChoVay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao So tien gui: ");
        double soTienGui = scanner.nextDouble();
        System.out.print("Nhap vao Ti le lai suat: ");
        double tiLeLaiSuat = scanner.nextDouble();
        System.out.print("Nhap vao So thang gui: ");
        double soThangGui = scanner.nextDouble();
        for (int i = 1; i <= soThangGui; i++) {
            double soTienLai = soTienGui * ((tiLeLaiSuat/100) / 12) * i;
            System.out.println("Tien lai thang " + i + " la: " + soTienLai);
        }
    }
}
