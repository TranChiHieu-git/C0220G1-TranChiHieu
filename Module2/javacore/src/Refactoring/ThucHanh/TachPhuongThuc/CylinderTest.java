package Refactoring.ThucHanh.TachPhuongThuc;

class CylinderTest {
    void testGetVolume0And0() {
        int radius = 0;
        int height = 0;
        //expected = 0;
        double result = Cylinder.getVolume(radius, height);
        System.out.println(result);
    }

    void testGetVolume1And2() {
        int radius = 1;
        int height = 2;
        //expected = 18.84955592153876;
        double result = Cylinder.getVolume(radius, height);
        System.out.println(result);
    }

    public static class Cylinder {
        public static double getVolume(int radius, int height) {
            double baseArea = getBaseArea(radius);
            double perimeter = getPerimeter(radius);
            double volume = perimeter * height + 2 * baseArea;
            return volume;
        }

        public static double getPerimeter(int radius) {
            return 2 * Math.PI * radius;
        }

        public static double getBaseArea(int radius) {
            return Math.PI * radius * radius;
        }
    }


    public static void main(String[] args) {
        CylinderTest cylinderTest = new CylinderTest();
        cylinderTest.testGetVolume0And0();
        cylinderTest.testGetVolume1And2();
    }
}