package AdvanceedObjectOrientedDesign.BaiTap.Resizeable.shapes;

public class Circle extends Shape{
    private double radius = 0.0;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.pow(this.getRadius(), 2) * Math.PI;
    }

    public double getPerimeter() {
        return 2 * this.getRadius() * Math.PI;
    }

    @Override
    public String toString() {
        String fill = isFilled() ? "filled" : "not filled";
        return "A Circle with radius=" + this.getRadius() + ", which is a subclass of " + super.toString();
    }

    @Override
    public void resize(double percent) {
        System.out.println("Circle area before resize: " + this.getArea());
        this.setRadius(this.getRadius() + (this.getRadius() * (percent / 100)));
        System.out.println("Circle area after resize: " + this.getArea());
    }
}
