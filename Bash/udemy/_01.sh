#!/bin/bash

X='test'

echo "i cant use any string next to $X"
echo "i can use any string next to ${X} (e.g=t${X}t)"

# ${?} -> a variable that keeps the exit status of last executed command


echo -e 'one\ttwo\tthree' | cut -c 1 #-> o
echo -e 'one\ttwo\tthree' | cut -c 1,3 #-> oe

echo -e 'one\ttwo\tthree' | cut -f 1 #-> one
echo -e 'one\ttwo\tthree' | cut -f 2 #-> two

echo 'one,two,three' | cut -d ',' -f 2 #-> two

echo 'one,two,three' | cut -d ',' --output-delimiter ':' #-> one:two:three

# data.dat file:
# DATA:firstDATA:last
# DATA:johnDATA:smitt
# DATA:firstlyDATA:mclasty
# DATA:Mr. firstlyDATA:mclasty

cut -d 'DATA:' -f 2 data.dat # -> it throws an error instead of showing first names.

awk -F 'DATA:' '{print $2}' data.dat # -> first
                                     #    john
                                     #    firstly
                                     #    Mr. firstly

awk -F 'DATA:' '{print $2, $3}' data.dat # -> first  last    -> because the delimiter of command of awk is space.
                                         #    john  smitt
                                         #    firstly  mclasty
                                         #    Mr. firstly  mclasty

awk -F 'DATA:' '{print $2 $3}' data.dat # -> first last
                                        #    john smitt
                                        #    firstly mclasty
                                        #    Mr. firstly mclasty

awk -F ':' -v OFS=',' '{print $2,$3}' data.dat # -> OFS is like --output-delimiter arg in cut

awk -F ':' -v OFS=',' '{print $NF}' data.dat # NF represents the index of the last field (e.g `$(NF - 1)` is last - 1)

