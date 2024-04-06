#! /bin/bash

res=1

factorial() {
    if [ $1 -eq 0 -o $1 -eq 1 ]
    then
        echo "$res"
    else
        res=$(( $res*$1 ))  
        factorial $(( $1-1 ))
    fi
}

factorial 6