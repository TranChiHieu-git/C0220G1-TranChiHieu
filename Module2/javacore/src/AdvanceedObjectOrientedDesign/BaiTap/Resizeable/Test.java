package AdvanceedObjectOrientedDesign.BaiTap.Resizeable;

import AdvanceedObjectOrientedDesign.BaiTap.Resizeable.shapes.Circle;
import AdvanceedObjectOrientedDesign.BaiTap.Resizeable.shapes.Rectangle;
import AdvanceedObjectOrientedDesign.BaiTap.Resizeable.shapes.Shape;
import AdvanceedObjectOrientedDesign.BaiTap.Resizeable.shapes.Square;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(4);
        shapes[1] = new Square(6);
        shapes[2] = new Rectangle(6, 3);
        for (Shape shape : shapes) {
            shape.resize(100);
            System.out.println();
        }
    }
}
