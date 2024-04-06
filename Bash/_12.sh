#! /bin/bash

echo -e "Dosya ismi: \c" # \c -> cursor
read dosyaismi

if [ -e $dosyaismi ]        # -e -> exists
then                        # -f -> exists and regular file
    echo "dosya bulundu"    # -s -> is not empty
else                        # -d -> is directory
    echo "dosya bulunamadi" # -r -> readable
fi                          # -w -> writable
                            # -x -> executable

