#! /bin/bash

select i in Balikesir Izmir Manisa
do
    case $i in
    Balikesir )
        echo "$i <3";;
    Izmir | Manisa )
        echo "$i";;
    * )
        break;;
    esac
done

for i in {1..10}
do
    if [ $((i%2)) != 0 ]
    then
        continue
    fi
    echo "$i"
done