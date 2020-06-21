package NgonNguLapTrinhJAVA.ThucHanh;

import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        String student[] = {"Tran", "Chi", "Hieu"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input name want found: ");
        String inputName = scanner.nextLine();
        boolean isPos = false;
        for (int i = 0; i < student.length; i++) {
            if (student[i].equals(inputName)) {
                System.out.println("position of " + inputName + " in the array is : " + (i + 1));
                isPos = true;
                break;
            }
        }
        if (!isPos) {
            System.out.println("Not found " + inputName + " in array");
        }
    }
}
