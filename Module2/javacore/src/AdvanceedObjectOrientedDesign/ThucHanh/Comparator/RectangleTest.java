package AdvanceedObjectOrientedDesign.ThucHanh.Comparator;

import KeThua.ThucHanh.HeCacDoiTuongHinhHoc.Rectangle;

import java.util.Arrays;
import java.util.Comparator;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle[] rectangle = new Rectangle[3];
        rectangle[0] = new Rectangle(3.5, 2.8);
        rectangle[1] = new Rectangle(4.1, 5.3, "red", true);
        rectangle[2] = new Rectangle();
        System.out.println("before sort: ");
        for (Rectangle rectangles : rectangle) {
            System.out.println(rectangles);
        }
        Comparator RectangleComparator = new RectangleComparator();
        Arrays.sort(rectangle, RectangleComparator);
        System.out.println("after sort: ");
        for (Rectangle rectangles : rectangle) {
            System.out.println(rectangles);
        }
    }
}
