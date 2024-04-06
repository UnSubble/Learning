#! /bin/bash

cikti(){
    local isim=$1
    echo "fonksiyon ici isim: $isim"
}

isim=Mehmet

echo "fonksiyon disi isim: $isim"

cikti Ahmet

echo "fonksiyon disi isim: $isim"