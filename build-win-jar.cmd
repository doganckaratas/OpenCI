@echo off
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

mkdir output
dir /s /B *.java > src.txt
javac -d .\output @src.txt
del src.txt
cd output
jar -cf OpenCI.jar OpenCI
move /Y OpenCI.jar ..\OpenCI.jar
cd ..
rmdir /S /Q output
