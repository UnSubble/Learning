#! /bin/bash

read input

case $input in 
    "1" )
        echo "1";;
    "2" )
        echo "2";;
    [a-z] )
        echo "Harf";;
    * )
        echo "-1";;
esac

# regEx -> [a-z] -> letter
#          [0-9] -> digit
#          ? -> special char