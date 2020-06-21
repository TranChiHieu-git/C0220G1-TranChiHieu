package KeThua.BaiTap.LopCircleVaCylinder;

public class Cylinder extends Circle {
    private double height = 1.0;

    Cylinder() {
    }

    Cylinder(double height) {
        this.height = height;
    }

    Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return Math.PI * Math.pow(this.getRadius(), 2) * this.getHeight();
    }

    public String toString() {
        return "A CylinderTest.Cylinder with height=" + this.getHeight() + " and volumn=" + this.getVolume() + ", which is a subclass of " + super.toString();
    }
}
