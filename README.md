# OpenCI
Open Source Computer Intelligence Library


## TODO for myself
- Add appropriate readme file here
- Add JavaDoc to source files
- Provide good and clean API 
- Create Utilities folder and add build tools in it
- ...

## Note 1:
For making standalone library file,
### Windows
- Please copy the code down below, then save with cmd extension in the same level with source folder, and run it.
``` bat
REM note: this file must be placed in same level with OpenCI source folder
REM directory tree should be;
REM 
REM .
REM |_ /OpenCI
REM | |_ /Audio
REM | |_ /IO
REM | |_ /Neural
REM | |_ ...
REM | 
REM |_ build-win-jar.cmd

@echo off
mkdir output
cd OpenCI 
dir /s /B *.java > ..\src.txt
javac -d ..\output @..\src.txt
cd ..
del src.txt
cd output
jar -cf OpenCI.jar OpenCI
move OpenCI.jar ..\OpenCI.jar
cd ..
rmdir /S /Q output
```

### Linux/Unix 
- Please copy the code down below, then save with sh extension in the same level with source folder, set permission and run it.
``` bash
#!/bin/bash
# please run chmod a+x build-linux-jar.sh before running.
# note: this file must be placed in same level with OpenCI source folder
# directory tree should be;
# 
# .
# |_ /OpenCI
# | |_ /Audio
# | |_ /IO
# | |_ /Neural
# | |_ ...
# | 
# |_ build-linux-jar.sh

mkdir output
cd OpenCI
find -name "*.java" > ../src.txt
javac -d ../output @../src.txt
cd ..
rm src.txt
cd output/
jar -cf OpenCI.jar OpenCI/
mv OpenCI.jar ../OpenCI.jar
cd ..
rm -rf output
``` 

### Using the newly created jar file
- For using this jar file with your source to be compiled, type "javac -cp .;{path-to-jar}.jar Test.java"
- For running, type "java -cp .;{path-to-jar}.jar Test"

Here are the sample program, "TestComplex.java";

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

then we just need to go into ``` text OpenCI-Tests ``` folder and type these commands,

javac -cp .;../OpenCI.jar TestComplex.java
java -cp .;../OpenCI.jar TestComplex

Congrats, you did it.
