package MangVaPhuongThucTrongJAVA.BaiTap;

import java.util.Scanner;

public class DemSoLanXuatHienCuaKyTuChuoi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "xin chao codegym!";
        System.out.print("Nhap vao ki tu muon so sanh: ");
        char inputStr = input.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (inputStr == str.charAt(i)) {
                count++;
            }
        }
        System.out.print("So lan xuat hien cua " + inputStr + " trong chuoi la: " + count);
    }
}
