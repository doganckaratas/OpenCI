import Numerical.*;

public class TestBase {
    public static void main(String[] args) {
        Complex c1 = new Complex(3,4);
        Complex c2 = new Complex(3,3);
        System.out.println("Compare " + c1.toString() + " == " + c2.toString());
		System.out.println(c1.compareTo(c2));
		
		// ------------------------------------------------------------
		
		Complex a = new Complex();
		Complex b = new Complex(5,-12);
		
		System.out.println("\nBefore Set");
		System.out.println(a.toString());
		System.out.println(b.toString());
		
		a.set(b);
		
		System.out.println("\nAfter Set");
		System.out.println(a.toString());
		System.out.println(b.toString() + "\n");
		
		// ------------------------------------------------------------
		
		a = new Complex();
		b = new Complex(5,12);
		
		System.out.println("Before Get");
		System.out.println(a.toString());
		System.out.println(b.toString() + "\n");
		
		a = b.get();
		
		System.out.println("\nAfter Get");
		System.out.println(a.toString());
		System.out.println(b.toString() + "\n");
		
		// ------------------------------------------------------------
		
		Complex[] dizi = new Complex[4]; // fourier tablosu olabilir
		for(int i = 0; i < dizi.length; i++) {
			//dizi[i] = new Complex(2*(i+1),-3*(i+1));
			dizi[i] = new Complex();
			dizi[i].setReal(2*(i+1));
			dizi[i].setImag(3*(i+1));
		}
		
		for(int i = 0; i < dizi.length; i++) {
			System.out.println(dizi[i].toString());
		}
		
		Polar p = new Polar(1,90);
		System.out.println("\n" + p.toString());
		Complex pc;
		pc = p.toComplex();
		System.out.println(pc.toString() + "\n");
		
		Complex cmp = new Complex();
		cmp.set(1,1);
		System.out.println(cmp.toString());
		Polar pm;
		pm = cmp.toPolar();
		System.out.println(pm.toString());
    }
}