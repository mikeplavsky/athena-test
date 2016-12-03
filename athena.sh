#!/bin/bash

export CLASSPATH=AthenaJDBC41-1.0.0.jar:aws-java-sdk-1.11.63/lib/*:aws-java-sdk-1.11.63/third-party/lib/*:$(pwd)/distr 
echo $CLASSPATH

echo "compiling..."
javac -d distr athena.java

if [ $? -eq 0  ]
then
    echo "Succeeded!"
else
    echo -e ${RED}"failed."
    exit -1
fi    

echo "running..."
java athena $1
