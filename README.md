# OpenCI
Open Source Computer Intelligence Library

Version: 0.1 Alpha

###### *Maintaining by Doğan Can Karataş, May 2017*


## TODO
- Add appropriate readme file here
- Add JavaDoc to source files
- Provide good and clean API 
- Create Utilities / Build-Tools folder and add build tools in it
- ...

## Making standalone jar 
Run `build-win-jar.cmd` for windows or `build-linux-jar.sh` for linux (after setting appropriate permissions).

The `OpenCI.jar` file will be appeared in the same folder after this operation.


## Using the jar 
- For compiling, type `javac -cp .;{path-to-jar}.jar Test.java` in console
- For running, type `java -cp .;{path-to-jar}.jar Test` in console

Here are the sample program, `TestComplex.java` ;

``` java
import OpenCI.Numerical.*;

public class TestComplex {
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
	
	Complex[] complexArray = new Complex[4]; // Could be Fourier Transform Array
	for(int i = 0; i < complexArray.length; i++) {
		//complexArray[i] = new Complex(2*(i+1),-3*(i+1));
		complexArray[i] = new Complex();
		complexArray[i].setReal(2*(i+1));
		complexArray[i].setImag(3*(i+1));
	}
	
	for(int i = 0; i < complexArray.length; i++) {
		System.out.println(complexArray[i].toString());
	}
    }
}
``` 

Let's assume our directory tree like this;

``` text

|_ OpenCI.jar
|
|_ OpenCI-Tests/
|  |_ TestComplex.java
| ...
``` 

then we just need to go into `OpenCI-Tests` folder and type these commands,

``` bat
javac -cp .;../OpenCI.jar TestComplex.java
java -cp .;../OpenCI.jar TestComplex
``` 

Congrats, you did it.
