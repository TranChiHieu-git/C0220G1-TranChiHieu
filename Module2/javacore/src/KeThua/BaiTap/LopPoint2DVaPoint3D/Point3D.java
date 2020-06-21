package KeThua.BaiTap.LopPoint2DVaPoint3D;

public class Point3D extends Point2D {
    private float z = 0.0f;

    Point3D() {
    }

    Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        this.setX(x);
        this.setY(y);
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[]{this.getX(), this.getY(), this.getZ()};
    }

    public String toString() {
        return "A Point 3D with cord x,y,z: (" + this.getX() + " , " + this.getY() + " , " + this.getZ() + ") and cord xyz: (" + this.getXYZ()[0] + "," + this.getXYZ()[1] + "," + this.getXYZ()[2] + "). This is a subclass of " + super.toString();
    }
}
