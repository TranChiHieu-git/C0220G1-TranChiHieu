package KeThua.BaiTap.LopCircleVaCylinder;

public class test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(10, "yellow");
        System.out.println(circle);
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(10);
        System.out.println(cylinder);
        cylinder = new Cylinder(15, 5, "blue");
        System.out.println(cylinder);
    }
}
