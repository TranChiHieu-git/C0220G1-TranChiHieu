package LopVaDoiTuongTrongJAVA.BaiTap.Fan;

public class Fan {
    private int speed = 1;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";
    public int getSpeed() {
        return this.speed;
    }

    public boolean getOn() {
        return this.on;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setSpeed(int value) {
        this.speed = value;
    }

    public void setOn(boolean value) {
        this.on = value;
    }

    public void setRadius(double value) {
        this.radius = value;
    }

    public void setColor(String value) {
        this.color = value;
    }
/*
    public String toString() {
        String speed = "";
        switch (getSpeed()) {
            case 1:
                speed = "LOW";
                break;
            case 2:
                speed = "MEDIUM";
                break;
            case 3:
                speed = "FAST";
                break;
        }
        String on_off = "";
        if (this.getOn())
            on_off = "on";
        else
            on_off = "off";
        return "speed: " + speed + ", color: " + this.getColor() + ", radius: " + this.getRadius() + ", fan is " + on_off;
    }*/
}
