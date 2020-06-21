package AdvanceedObjectOrientedDesign.ThucHanh.Comparator;

import KeThua.ThucHanh.HeCacDoiTuongHinhHoc.Square;

import java.util.Comparator;

public class SquareComparator implements Comparator<Square> {
    public int compare(Square s1, Square s2) {
        if (s1.getSide() > s2.getSide()) return 1;
        else if (s1.getSide() < s2.getSide()) return -1;
        else return 0;
    }
}
