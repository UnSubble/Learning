#! /bin/bash

yas=28

# && -> and / syntax: [] && [] veya [[ && ]]
# -a -> and / syntax: [ -a ]
# || -> or / syntax: [] || [] veya [[ || ]]
# -o -> or / syntax: [ -o ]

if [ "$yas" -gt 27 ] && [ "$yas" -lt 100 ]
then
    echo "Yas 27'den buyuk 100'den kucuk"
fi