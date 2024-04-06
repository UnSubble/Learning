#! /bin/bash

# RegEx
# ^ $ . * [] [^] -> hepsi java regEx ile ayni

# ornek kullanim
# cat $dosya_ismi$ | grep $regEx$
# cat $dosya_ismi$ | grep -i $regEx$ ( -i -> Case Insensitive )
# cat $dosya_ismi$ | grep -v $regEx$ ( -v -> ifadenin degilini alir )
# cat $dosya_ismi$ | grep $regEx$ | grep $regEx$ ( | -> ve anlami tasir )
# cat $dosya_ismi$ | grep -ic $regEx$ ( -i -> case insensitive / -c -> count)
# cat $dosya_ismi$ | grep -in $regEx$ ( -i -> case insensitive / -n -> index)