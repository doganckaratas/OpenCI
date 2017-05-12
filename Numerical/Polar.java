/**
 * Polar.java
 *
 * @author dogan can karatas
 * @version 1.0
 */

package OpenCISP.Numerical;

public class Polar {
    private double radius;
    private double angle;
    private String unit = "degree"; // "degree", "radian"

    public Polar() {
        this.radius = 0;
        this.angle = 0;
    }

    public Polar(double R, double theta) {
        this.radius = R;
        this.angle = theta;
    }

    public void set(Polar p) {
        this.radius = p.getRadius();
        this.angle = p.getAngle();
    }

    public void set(double R, double theta) {
        this.radius = R;
        this.angle = theta;
    }

    public Polar get() {
        return new Polar(this.radius,this.angle);
    }

    public void setRadius(double R) {
        this.radius = R;
    }

    public void setAngle(double theta) {
        this.angle = theta;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getAngle() {
        return this.angle;
    }

    public boolean compareTo(Polar p) {
        if(this.radius == p.getRadius() && this.angle == p.getAngle()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean compareTo(double R, double theta) {
        if(this.radius == R && this.angle == theta) {
            return true;
        } else {
            return false;
        }
    }

    public Complex toComplex(){
        switch(this.unit) {
            case "degree":
                return new Complex((this.radius * Math.cos(Math.toRadians(this.angle))), (this.radius * Math.sin(Math.toRadians(this.angle))));
            case "radian":
                return new Complex((this.radius * Math.cos(Math.toRadians(this.angle))), (this.radius * Math.sin(this.angle)));
            default:
                return new Complex(0, 0);
        }
    }

    public String toString(){
        return String.valueOf(this.radius + "|" + this.angle);
    }
}