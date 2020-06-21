package MangVaPhuongThucTrongJAVA.ThucHanh;

import java.util.Scanner;

public class DemSoLuongSinhVienThiDo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberStudent;
        do {
            System.out.print("Nhap vao so luong hoc sinh muon kiem tra: ");
            numberStudent = input.nextInt();
        } while (numberStudent > 30);
        double[] arrScore = new double[numberStudent];
        for (int i = 0; i < numberStudent; i++) {
            System.out.print("Nhap vao diem cua hoc vien " + (i + 1) + " : ");
            arrScore[i] = input.nextDouble();
        }
        int count = 0;
        for (int i = 0; i < numberStudent; i++) {
            if (arrScore[i] >= 5) {
                count++;
            }
        }
        System.out.print("So luong hoc sinh qua mon la: " + count + " hoc sinh");
    }
}
