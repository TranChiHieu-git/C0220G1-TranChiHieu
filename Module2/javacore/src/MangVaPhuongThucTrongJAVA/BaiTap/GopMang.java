package MangVaPhuongThucTrongJAVA.BaiTap;

public class GopMang {
    public static void main(String[] args) {
        int[] arr1 = {4, 2, 7};
        int[] arr2 = {1, 3, 7, 7};
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr3.length; i++) {
            if (i < arr1.length) {
                arr3[i] = arr1[i];
            }
            else {
                arr3[i]=arr2[i-arr1.length];
            }
        }
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
