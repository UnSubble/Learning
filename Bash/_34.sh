#! /bin/bash

echo -e "Write the path of the file: \c"
read target_file

while read -r line 
do
    echo "$line"
done < $target_file