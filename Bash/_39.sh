#! /bin/bash

# Word Frequency
declare -A arr
declare -a words
declare -A res_arr

while IFS=$"\n" read -r line
do
    for i in ${line}
    do
        if [[ ${arr[$i]} = '' ]]
        then
            arr[$i]=0
            words[${#words[@]}]=$i
        fi
        arr[$i]=$(( ${arr[$i]}+1 ))
    done
done < 'words.txt'

for i in ${words[@]}
do 
    res_arr[${arr[$i]}]=$i
done

IFS=$'\n' r=($(sort -n <<<"${arr[*]}"))
unset IFS

for (( i=${#r[@]}-1; i>=0; i-- ))
do 
    echo "${res_arr[${r[$i]}]} ${r[$i]}"
done

#Word Frequency
declare -A counts
while read line; do
    for word in $line; do
        ((counts["$word"]++))
    done
done < words.txt

for word in ${!counts[@]}; 
do 
    echo "$word ${counts[$word]}"
done | sort -k2 -nr