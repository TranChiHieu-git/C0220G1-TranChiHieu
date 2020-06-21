package AdvanceedObjectOrientedDesign.BaiTap.Colorable;

import AdvanceedObjectOrientedDesign.BaiTap.Colorable.shape.Square;
import AdvanceedObjectOrientedDesign.BaiTap.Colorable.shape.Circle;
import AdvanceedObjectOrientedDesign.BaiTap.Colorable.shape.Rectangle;
import AdvanceedObjectOrientedDesign.BaiTap.Colorable.shape.Shape;

public class test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5.4, "red", true);
        shapes[1] = new Rectangle(2.5, 5.4, "blue", true);
        shapes[2] = new Square(4.0, "black", true);
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println("circle: " + ((Circle) shape).getArea());
            } else if (shape instanceof Square) {
                System.out.println("square: " + ((Square) shape).getArea());
                ((Square) shape).howToColor();
            } else if (shape instanceof Rectangle) {
                System.out.println("rectengle:" + ((Rectangle) shape).getArea());
            }
        }
    }
}
