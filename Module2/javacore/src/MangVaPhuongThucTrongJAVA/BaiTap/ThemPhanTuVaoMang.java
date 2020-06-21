package MangVaPhuongThucTrongJAVA.BaiTap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index, value;
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vao gia tri muon them vao mang: ");
        value = input.nextInt();
        do {
            System.out.print("Nhap vao vi tri muon them vao mang: ");
            index = input.nextInt();
        } while (index < 0 && index > arr.length);
        int[] tempArr = new int[arr.length + 1];
        for (int i = 0; i < tempArr.length - 1; i++) {
            tempArr[i] = arr[i];
        }

        for (int i = tempArr.length - 1; i >= index; i--) {
            tempArr[i] = tempArr[i - 1];
        }
        tempArr[index] = value;
        arr = new int[11];
        arr = tempArr;
        tempArr = null;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
