#! /bin/bash

echo $(( 1+1 ))
echo $(( 1/2 ))

sayi1=10
sayi2=20
echo $(( sayi1-sayi2 ))
echo $(( sayi2%sayi1 ))

echo $( expr $sayi1 + $sayi2 )
echo $( expr $sayi1 / $sayi2 )
# echo $( expr $sayi1 * $sayi2 ) -> THROWS AN ERROR
echo $( expr $sayi1 \* $sayi2 )