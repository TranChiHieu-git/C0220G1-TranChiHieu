package AdvanceedObjectOrientedDesign.ThucHanh.Comparable;

import KeThua.ThucHanh.HeCacDoiTuongHinhHoc.Square;

public class ComparableSquare extends Square implements Comparable<ComparableSquare> {
    public ComparableSquare() {

    }

    public ComparableSquare(double side) {
        super(side);
    }

    public ComparableSquare(double side, String color, boolean filled) {
        super(side, color, filled);
    }

    @Override
    public int compareTo(ComparableSquare o) {
        if (this.getArea() > o.getArea()) return 1;
        else if (this.getArea() < o.getArea()) return -1;
        else return 0;
    }
}
