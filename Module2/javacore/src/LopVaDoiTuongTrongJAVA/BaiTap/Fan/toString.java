package LopVaDoiTuongTrongJAVA.BaiTap.Fan;

import java.util.SortedSet;
import java.util.TreeSet;

public class toString {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        Fan fan2 = new Fan();
        fan2.setSpeed(3);
        fan2.setRadius(10);
        fan2.setColor("yellow");
        fan2.setOn(true);
        System.out.println("quat 1: " + fan1.hashCode());
        System.out.println("quat 2: " + fan2.hashCode());
    }
}
