package MangVaPhuongThucTrongJAVA.BaiTap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 4, 5, 8, 2, 5, 4, 6, 3, 5, 7, 9, 1, 3, 5, 4, 8, 6};
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vao gia tri muon xoa: ");
        int value = input.nextInt();
        int index_del = 0;
        while (index_del != -1) {
            for (int i = 0; i < arr.length; i++) {
                if (value == arr[i]) {
                    index_del = i;
                    for (i = index_del; i < arr.length - 1; i++) {
                        arr[i] = arr[i + 1];
                    }
                    arr[arr.length - 1] = 0;
                } else {
                    index_del = -1;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
