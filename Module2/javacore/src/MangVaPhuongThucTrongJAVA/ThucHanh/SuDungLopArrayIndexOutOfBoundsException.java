package MangVaPhuongThucTrongJAVA.ThucHanh;

import java.util.Scanner;

public class SuDungLopArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        ArrayExample arrExample = new ArrayExample();
        int[] arr = arrExample.createRandom();

        Scanner scaner = new Scanner(System.in);
        System.out.println("\nVui lòng nhập chỉ số của một phần tử bất kỳ: ");
        int x = scaner.nextInt();
        try {
            System.out.println("Giá trị của phần tử có chỉ số " + x + " là " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Chỉ số vượt quá giới hạn của mảng");
        }
    }

    public static class ArrayExample {
        public int[] createRandom() {
            int[] arr = new int[100];
            for (int i = 0; i < 100; i++) {
                arr[i] = (int) Math.round((Math.random() * 100) + 1);
            }
            return arr;
        }
    }
}


