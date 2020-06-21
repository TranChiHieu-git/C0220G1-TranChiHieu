package KeThua.BaiTap.LopPoint2DVaPoint3D;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    Point2D() {

    }

    Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
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
        return "A Point 2D with cord x,y: (" + this.getX() + " , " + this.getY() + ") and cord xy: (" + this.getXY()[0] + "," + this.getXY()[1] + ")";
    }
}
