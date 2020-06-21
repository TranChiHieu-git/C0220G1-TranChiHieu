package MangVaPhuongThucTrongJAVA.ThucHanh;

import java.util.Scanner;

public class TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberPeople = 1;
        do {
            System.out.print("Nhap vao so luong ti phu: ");
            numberPeople = scanner.nextInt();
            if (numberPeople > 20) {
                System.out.println("So luong ti phu khong qua 20!!!");
            }
        } while (numberPeople > 20);
        int[] arrMoney = new int[numberPeople];
        for (int i = 0; i < numberPeople; i++) {
            System.out.print("Nhap vao so tien cua ti phu thu " + (i + 1)+" : ");
            arrMoney[i] = scanner.nextInt();
        }
        int max = arrMoney[0];
        int pos = 0;
        for (int i = 1; i < arrMoney.length; i++) {
            if (max < arrMoney[i]) {
                max = arrMoney[i];
                pos = i+1;
            }
        }
        System.out.println("Ti phu co tai san lon nhat la :" + max + " USD o vi tri: " + pos);
    }
}
