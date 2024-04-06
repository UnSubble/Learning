#! /bin/bash

echo -e "File Name: \c"
read target_file

if [ -f $target_file ] && [ -w $target_file ]
then
    echo "Basarili. You can write the target file. If you want exit press [ctrl+d]."
    cat >> $target_file
fi