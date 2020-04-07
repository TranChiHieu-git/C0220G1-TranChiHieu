import java.util.Scanner;

public class KiemTraSoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so muon kiem tra:");
        int number = scanner.nextInt();
        if (number < 2) {
            System.out.print(number + " is not a prime");
        } else {
            boolean check = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    check = false;
                }
            }
            if (check) {
                System.out.print(number + " is a prime");
            } else {
                System.out.print(number + " is not a prime");
            }
        }
    }
}
