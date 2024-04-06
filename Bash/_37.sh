#! /bin/bash

# valid phone numbers
while read -r line
do
    if [[ $line =~ ^((\([0-9]{3}\)\ )|([0-9]{3}\-))([0-9]{3}-[0-9]{4})[^0-9]?$ ]]
    then
        echo "$line"
    fi
done < file.txt

# valid phone numbers
grep '^\([0-9]\{3\}-\|([0-9]\{3\}) \)[0-9]\{3\}-[0-9]\{4\}$' file.txt