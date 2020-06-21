package AdvanceedObjectOrientedDesign.ThucHanh.Comparator;

import KeThua.ThucHanh.HeCacDoiTuongHinhHoc.Square;

import java.util.Arrays;
import java.util.Comparator;

public class SquareTest {
    public static void main(String[] args) {
        Square[] square = new Square[3];
        square[0] = new Square();
        square[1] = new Square(8.4);
        square[2] = new Square(3.5, "blue", false);
        System.out.println("before sort");
        for (Square squares : square) {
            System.out.println(squares);
        }
        Comparator comparator = new RectangleComparator();
        Arrays.sort(square,comparator);
        System.out.println("after sort");
        for (Square squares : square) {
            System.out.println(squares);
        }
    }
}
