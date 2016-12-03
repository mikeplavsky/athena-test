#!/bin/bash

export CLASSPATH=commons-logging-1.2.jar:AthenaJDBC41-1.0.0.jar:aws-java-sdk-1.11.63.jar:$(pwd) 
echo $CLASSPATH

echo "compiling..."
javac athena.java

if [ $? -eq 0  ]
then
    echo "Succeeded!"
else
    echo -e ${RED}"failed."
    exit -1
fi    

echo "running..."
java athena $1
