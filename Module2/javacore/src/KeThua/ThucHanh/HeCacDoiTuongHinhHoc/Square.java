package KeThua.ThucHanh.HeCacDoiTuongHinhHoc;

public class Square extends Rectangle {
    private double side = 1.0;

    public Square() {

    }

    public Square(double side) {
        super(side, side);
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
        this.side = side;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void setHeight(double height) {
        this.setSide(height);
    }

    @Override
    public void setWidth(double width) {
        this.setSide(width);
    }

    @Override
    public String toString() {
        String fill = isFilled() ? "filled" : "not filled";
        return "A Square with side=" + this.getSide() + ", which is a subclass of " + super.toString();
    }
}
