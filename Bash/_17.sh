#! /bin/bash

i=1

while [ $i -le 4 ]
do
    echo $i
    ((i++))
    sleep 0.5
    gnome-terminal 
    # gnome-terminal & -> arka planda çalıştırır.
done