package KeThua.BaiTap.LopPointVaMoveablepoint;

public class Moveablepoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    Moveablepoint() {
    }

    Moveablepoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    Moveablepoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.setxSpeed(xSpeed);
        this.setySpeed(ySpeed);
    }

    public float[] getSpeed() {
        return new float[]{this.getxSpeed(), this.getySpeed()};
    }

    public float[] move() {
        this.setX(this.getX() + this.getxSpeed());
        this.setY(this.getY() + this.getySpeed());
        return this.getSpeed();
    }

    public String toString() {
        return "(" + this.getX() + "," + this.getY() + "), speed=(" + this.getSpeed()[0] + "," + this.getSpeed()[1] + ")";
    }


}
