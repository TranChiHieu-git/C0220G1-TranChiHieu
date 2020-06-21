package MangVaPhuongThucTrongJAVA.BaiTap;

import java.util.Scanner;

public class TinhTongCacSoDuongCheoChinhCuaMaTranVuong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vao hang va cot cua ma tran: ");
        int n = input.nextInt();
        long[][] arr = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Math.round(Math.random() * 100);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.print("Tong cac phan tu thuoc duong cheo chinh la: "+sum);
    }
}
