#! /bin/bash

# n. satirdaki line'i okuma
tenth_line=;

for i in {1..10}
do
    read -r tenth_line 
done < file.txt
echo $tenth_line

# n. satirdaki line'i okuma 
echo `sed -n '10p' < "file.txt"`

# n. satirdaki line'i okuma 
count=1
while IFS= read -r line
do
    if (( count == 10 ))
    then
        echo $line
        break;
    else
        (( count++ ))
    fi
done < file.txt