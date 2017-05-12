/**
 * Complex.java
 *
 * @author dogan can karatas
 * @version 1.0
 */

package OpenCIL.Numerical;

public class Complex {
    private double real;
    private double imag;
	private String unit = "degree"; // "degree", "radian"

    public Complex() {
        this.real = 0.0D;
        this.imag = 0.0D;
    }

    public Complex(double i, double j) {
        this.real = i;
        this.imag = j;
    }

    public void set(Complex c) {
        this.real = c.getReal();
        this.imag = c.getImag();
    }
	
	public void set(double i, double j) {
		this.real = i;
		this.imag = j;
	}

    public Complex get() {
        return new Complex(this.real, this.imag);
    }

    public void setReal(double i) {
        this.real = i;
    }

    public void setImag(double j) {
        this.imag = j;
    }

    public double getReal() {
        return this.real;
    }

    public double getImag() {
        return this.imag;
    }

    public boolean compareTo(Complex c) {
        if (this.real == c.getReal() && this.imag == c.getImag()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean compareTo(double i, double j) {
        if (this.real == i && this.imag == j) {
            return true;
        } else {
            return false;
        }
    }

	public Polar toPolar() {
		try{
			switch(this.unit) {
				case "degree":
					return new Polar( Math.sqrt(Math.pow(this.real,2) + Math.pow(this.imag,2)),Math.toDegrees(Math.atan(this.imag / this.real)) );
				case "radian":
					return new Polar( Math.sqrt(Math.pow(this.real,2) + Math.pow(this.imag,2)),Math.atan(this.imag / this.real) );
				default:
					return new Polar(0,0);
			}
		} catch (ArithmeticException ae) {
					return new Polar(0,0);
		}
	}

	public String toString() {
        if(this.imag < 0) {
            return String.valueOf(this.real + "-" + (-this.imag) + "i");
        } else {
            return String.valueOf(this.real + "+" +this.imag + "i");
        }
    }
}