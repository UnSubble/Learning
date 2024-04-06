#! /bin/bash

# Transpose File
declare -a arr

while read -r line 
do
    arr[${#arr[@]}]=$line
done < 'file.txt'

list=(${arr[0]})
length=${#list[@]}

for (( i=0; i<length; i++ ))
do
    for (( j=0; j<${#arr[@]}; j++ ))
    do
        target_list=(${arr[$j]})
        echo -e "${target_list[$i]}\c"
        if [[ $j -lt ${#arr[@]}-1 ]]
        then
            echo -e ' \c'
        fi
    done
    echo
done

# Transpose File
awk '
{
    for (i = 1; i <= NF; i++) {
        if (FNR == 1) {
            t[i] = $i;
        } else {
            t[i] = t[i] " " $i
        }
    }
}
END {
    for (i = 1; t[i] != ""; i++) {
        print t[i]
    }
}
' file.txt