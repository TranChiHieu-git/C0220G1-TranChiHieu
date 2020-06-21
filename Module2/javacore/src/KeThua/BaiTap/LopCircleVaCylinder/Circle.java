package KeThua.BaiTap.LopCircleVaCylinder;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    Circle() {

    }

    Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.pow(this.getRadius(), 2) * Math.PI;
    }

    public double getPerimeter() {
        return 2 * this.getRadius() * Math.PI;
    }

    public String toString() {
        return "A Circle with radius=" + this.getRadius() + " and color of " + this.getColor();
    }
}
