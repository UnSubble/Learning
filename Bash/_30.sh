#! /bin/bash

# [:blank:] -> bosluk yani \s

if ! [[ $1 =~ ^[:blank:]*[0-9]*[:blank:]*$ ]]
then
    echo "Hatali giris yaptiniz"
fi
