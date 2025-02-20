#! /bin/bash

# INT Karsilastirma
# if [] icin
# -eq -> equal
# -ne -> not equal
# -lt -> less than
# -le -> less than and equal
# -gt -> greater than
# -ge -> greater than and equal
# if (()) icin
# <
# <=
# >
# >= 

# STRING Karsilastirma
# if [] icin
# = -> equal
# == -> equal (for pattern matching)
# != -> not equal
# < -> less than
# > -> greater than

read -p "2 Sayi giriniz: " sayi1 sayi2
if [ "$sayi1" -eq "$sayi2" ]
then
    echo "iki sayi esit"
fi

if (( "$sayi1" < 10 ))
then
    echo "1. sayi 10'dan kucuk."
fi

if (( $sayi1 > 0 ))
then
    echo "1. sayi pozitif"
elif (( $sayi1 < 0 ))
then
    echo "1. sayi negatif"
else
    echo "sayi sifir"
fi