package NgonNguLapTrinhJAVA.BaiTap;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        int count = 0;
        int i = 2;
        while (i<100) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                count++;
                System.out.println(count + ".So nguyen to la: " + i);
            }
            i++;
        }
    }
}
