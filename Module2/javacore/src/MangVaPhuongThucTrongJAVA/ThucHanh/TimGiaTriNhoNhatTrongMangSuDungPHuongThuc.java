package MangVaPhuongThucTrongJAVA.ThucHanh;

public class TimGiaTriNhoNhatTrongMangSuDungPHuongThuc {
    public static void main(String[] args) {
        int arr[] = {9, 5, -4, 7, 3, 6, 4, 15, 8};
        int index = posMinInArr(arr);
        System.out.println("gia tri nho nhat trong mang la: " + arr[index]);
    }

    public static int posMinInArr(int[] arr) {
        int index = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}
