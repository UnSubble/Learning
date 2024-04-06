#! /bin/bash

read -p "Sayi: "

n=0

while [ $n -lt $REPLY ]
do
    n=$(( n+1 )) 
    echo $n
done

n=0

while [ $n -lt $REPLY ]
do
    ((n++))
    echo $n
    sleep 0.5
done

echo "done"