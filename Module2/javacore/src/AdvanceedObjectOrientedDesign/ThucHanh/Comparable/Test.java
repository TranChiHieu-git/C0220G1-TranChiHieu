package AdvanceedObjectOrientedDesign.ThucHanh.Comparable;

import KeThua.ThucHanh.HeCacDoiTuongHinhHoc.Circle;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(4);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(2, "black", true);

        System.out.println("before sort: ");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
        Arrays.sort(circles);
        System.out.println("after sort: ");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
        //--------------------------------------------------------------------------------------------------------------
        ComparableRectangle[] rectangles = new ComparableRectangle[3];
        rectangles[0] = new ComparableRectangle(4, 1);
        rectangles[1] = new ComparableRectangle();
        rectangles[2] = new ComparableRectangle(3, 2, "black", true);

        System.out.println("before sort: ");
        for (ComparableRectangle rectangle : rectangles) {
            System.out.println(rectangle.getArea());
        }
        Arrays.sort(rectangles);
        System.out.println("after sort: ");
        for (ComparableRectangle rectangle : rectangles) {
            System.out.println(rectangle.getArea());
        }
        //--------------------------------------------------------------------------------------------------------------
        ComparableSquare[] squares = new ComparableSquare[3];
        squares[0] = new ComparableSquare(4, "red", false);
        squares[1] = new ComparableSquare(3);
        squares[2] = new ComparableSquare();

        System.out.println("before sort: ");
        for (ComparableSquare square : squares) {
            System.out.println(square.getArea());
        }
        Arrays.sort(squares);
        System.out.println("after sort: ");
        for (ComparableSquare square : squares) {
            System.out.println(square.getArea());
        }
    }
}
