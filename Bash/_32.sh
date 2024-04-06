#! /bin/bash

# $RANDOM -> random sayi icin
# $date -> takvim icin

# test=konya; echo ${test:-karaman} -> eger degisken bossa karaman yazdirir. Doluysa degiskeni yazdirir.
# test=; echo ${test:=karaman} -> karaman'i bossa degiskene atar ve degiskeni yazdirir.
# test=; echo ${test:?tanimsiz} -> degisken bossa tanimsiz yazar.
# test=konya; echo ${test:+karaman} -> eger degiskenin degeri varsa karaman'i atar ve yazdirir.
# test=konya; echo ${#test} -> test degiskeninin degerinin length'ini verir.
# test=konya; echo ${test:3} -> 3. indexten sona kadar substring yapar. (ya)
# test=konya; echo ${test:1:3} -> 1. indexten 3. indexe kadar substring yapar. (ony)
# test=/user/desktop/main.py; echo ${test##/*/} -> /user/desktop/ kismini siler. (en uzun / ve / arasini) (# -> soldan baslar)
# test=/user/desktop/main.py; echo ${test#/*/} -> /user/ kismini siler. (en kisa / ve / arasini)
# test=/user/desktop/main.py; echo ${test%%/*/} -> /user/desktop/ kismini siler. (en uzun / ve / arasini) (% -> sagdan baslar)
# test=/user/desktop/main.py; echo ${test#/*/} -> /user/ kismini siler. (en kisa / ve / arasini)
# test=konya; echo ${konya^*} -> ilk harfi buyultur (Konya)
# test=konya; echo ${konya^^*} -> tum harfleri buyultur (KONYA)
# test=KONYA; echo ${konya,*} -> ilk harfi kucultur (kONYA)
# test=KONYA; echo ${konya,,*} -> tum harfleri kucultur (konya)
# test=KONYA; test2=test; echo ${!test2} -> test2 -> test / test -> konya degerini tutuyor. Biz test2'ye test'in degerini kullan diyoruz.
# test=/user/desktop/main.py; echo ${test/user/resu} -> /resu/desktop/main.py
# test=/user/desktop/main.py; echo ${test//user/resu} -> /resu/desktop/main.py (// -> tum user'lari resu yapar.)
# test=123.456; test2=${test/.}; echo $test2 -> 123456 yazar. Noktayi siler.
# test=123.456; test2=${test/.*}; echo $test2 -> 123 yazar. Noktayi ve noktadan sonraki her seyi siler.
# test=shscript.sh; echo ${test/#sh/bash} -> bashscript.sh
# test=shscript.sh; echo ${test/%sh/bash} -> shscript.bash
