package KeThua.BaiTap.LopPointVaMoveablepoint;

public class test {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        point = new Point(4, 5);
        System.out.println(point);

        Moveablepoint move = new Moveablepoint();
        System.out.println(move);
        move.move();
        move.move();
        System.out.println(move);
        move = new Moveablepoint(4, 3);
        System.out.println(move);
        move.move();
        move.move();
        System.out.println(move);
        move = new Moveablepoint(7, 9, 1, 6);
        System.out.println(move);
        move.move();
        move.move();
        System.out.println(move);
    }
}
