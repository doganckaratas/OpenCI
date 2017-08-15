#!/bin/bash
# please run chmod a+x build-linux-jar.sh before running.

mkdir output
find -name "*.java" > src.txt
javac -d ./output @src.txt
rm src.txt
cd output/
jar -cf OpenCI.jar openci/
mv OpenCI.jar ../OpenCI.jar
cd ..
rm -rf output
