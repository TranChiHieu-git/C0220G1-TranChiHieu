package KeThua.BaiTap.LopPointVaMoveablepoint;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    Point() {

    }

    Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        return new float[]{this.getX(), this.getY()};
    }

    public String toString() {
        return "x,y: (" + this.getX() + " , " + this.getY() + ")";
    }
}
