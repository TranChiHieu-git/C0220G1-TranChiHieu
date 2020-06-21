package MangVaPhuongThucTrongJAVA.ThucHanh;

import java.util.Scanner;

public class DaoNguocCacPhanTuTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberIndex;
        do {
            System.out.print("Nhap vao so luong phan tu cua mang: ");
            numberIndex = scanner.nextInt();
            if (numberIndex > 20) {
                System.out.println("So luong khong qua 20!!!");
            }
        } while (numberIndex > 20);
        int[] arr = new int[numberIndex];
        for (int i = 0; i < numberIndex; i++) {
            System.out.print("Nhap vao phan tu thu " + (i + 1) + " : ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Chua dao nguoc: ");
        for (int i = 0; i < numberIndex; i++) {
            System.out.println("phan tu thu " + (i + 1) + " : " + arr[i]);
        }
        for (int i = 0; i < numberIndex/2; i++) {
            int temp = arr[i];
            arr[i]=arr[numberIndex-1-i];
            arr[numberIndex-1-i]=temp;
        }
        System.out.println("Da dao nguoc: ");
        for (int i = 0; i < numberIndex; i++) {
            System.out.println("phan tu thu " + (i + 1) + " : " + arr[i]);
        }
    }
}
