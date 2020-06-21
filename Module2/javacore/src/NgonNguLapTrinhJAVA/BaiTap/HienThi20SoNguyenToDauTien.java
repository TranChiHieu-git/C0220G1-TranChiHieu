package NgonNguLapTrinhJAVA.BaiTap;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        int count = 0;
        int i = 2;
        while (count<20) {
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
