package MangVaPhuongThucTrongJAVA.BaiTap;

import java.util.Scanner;

public class TinhTongCacSoOMotCotXacDinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] arr = new double[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("Nhap vao phan tu hang " + i + " cot " + j + " : ");
                arr[i][j] = scanner.nextDouble();
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Nhap vao so hang muon tinh tong: ");
        int row = scanner.nextInt();
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[row][i];
        }
        System.out.print("Tong cac phan tu hang " + row + " la: " + sum);
    }
}
