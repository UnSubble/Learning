#! /bin/bash

function fonk(){
    echo "Hello, Function!"
}

cikis() {
    echo "cikis yapiliyor..."
    sleep 1
    exit
}

fonk
cikis
echo "test"