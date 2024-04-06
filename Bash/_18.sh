#! /bin/bash

for (( i = 0; i<5; i++ ))
do
    echo $(( i+1 ))
done

echo "-------------------------------"

for i in 1 2 3 4 5
do
    echo $i
done

echo "-------------------------------"

for i in ls pwd
do

    echo -------------$i---------------
    $i
done

echo "-------------------------------"

for i in {1..10}
do
    echo $i
done

echo "-------------------------------"

for i in {1..10..3}
do
    echo $i
done