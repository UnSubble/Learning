#! /bin/bash

echo "20.5+5" | bc
echo "10.5/5" | bc
echo "sqrt(16)" | bc

echo "scale=2;20.5/5" | bc

sayi=10.457345
echo "scale=5;sqrt($sayi)" | bc -l # -l = library
echo "$sayi^3" | bc -l