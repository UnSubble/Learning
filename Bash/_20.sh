#! /bin/bash

select i in 'Linux' 'Windows' 'Unix'
do
    case $i in 
    Linux )
        echo "best";;
    Windows )
        echo "meeh";;
    Unix )
        echo "idontgetit";;
    * )
        echo "empty is greater than windows";;
    esac
done