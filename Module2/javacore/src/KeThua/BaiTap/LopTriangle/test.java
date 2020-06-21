package KeThua.BaiTap.LopTriangle;

public class test {
    public static void main(String[] args) {
        Triangle triangle=new Triangle();
        System.out.println(triangle);
        triangle=new Triangle(5.0,6.0,7.0);
        System.out.println(triangle);
        triangle=new Triangle(4.0,2.0,3.0,"yellow",true);
        System.out.println(triangle);
    }
}
