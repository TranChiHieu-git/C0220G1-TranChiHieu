package AdvanceedObjectOrientedDesign.ThucHanh.Comparator;

import KeThua.ThucHanh.HeCacDoiTuongHinhHoc.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class CircleTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "green", false);

        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
        Comparator CircleComparator = new CircleComparator();
        Arrays.sort(circles, CircleComparator);
        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
