#! /bin/bash

function pow(){
    echo $(( $1*$1 ))
} 

read -p "Sayi: " sayi

pow $sayi

carp() {
    echo $(( $1*$2 ))
}

read -p "Sayilar: " sayi1 sayi2

carp $sayi1 sayi2