package LopVaDoiTuongTrongJAVA.BaiTap.StopWatch;

public class selectsort {
    public static void main(String[] args) {
        StopWatch time = new StopWatch();
        time.start();
        int arr[] = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round((Math.random() * 1000) + 1);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        time.stop();
        System.out.println();
        System.out.println("time thuc hien chuong trinh: " + time.getElapsedTime() + " mili giay");
    }
}
