package KeThua.ThucHanh.HeCacDoiTuongHinhHoc;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double height = 1.0;

    public Rectangle() {

    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return this.getWidth() * this.getHeight();
    }

    public double getPerimeter() {
        return (this.getWidth() + this.getHeight()) * 2;
    }

    @Override
    public String toString() {
        String fill = isFilled() ? "filled" : "not filled";
        return "A Rectangle with width=" + this.getWidth() + " and length=" + this.getHeight() + ", which is a subclass of " + super.toString();
    }
}
