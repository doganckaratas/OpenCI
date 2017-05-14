# OpenCI
Open Source Computer Intelligence Library


## TODO for myself
- Add appropriate readme file here
- Add JavaDoc to source files
- Provide good and clean API 
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
