#!/bin/bash

echo "compiling..."
javac athena.java -cp AthenaJDBC41-1.0.0.jar

if [ $? -eq 0  ]
then
    echo "Succeeded!"
else
    echo -e ${RED}"failed."
    exit -1
fi    

echo "running..."

java -cp "AthenaJDBC41-1.0.0.jar":$(pwd) \
    athena $1
