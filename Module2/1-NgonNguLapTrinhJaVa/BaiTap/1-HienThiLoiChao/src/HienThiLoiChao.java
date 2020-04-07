import java.util.Scanner;

public class HienThiLoiChao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vao ten cua ban: ");
        String name = input.nextLine();
        System.out.print("Xin chao "+name);
    }
}
