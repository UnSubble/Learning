#! /bin/bash

# ; -> komutlari yan yana yazabilmemizi saglar
# * -> Mesela u* -> u ile baslayan her sey (RegEx'teki bir veya daha fazla gibi ama herhangi bir harf olabiliyor)
# ? -> Mesela ?? -> iki harfli olan her sey
# [] -> Mesela [de] -> d veya e ile baslayan / [0-9] -> rakamlar
# ^ -> Mesela [^k] -> k ile baslamayanlar / ^k -> baslangici k olanlar
# {} -> Mesela merhaba{ali,veli}selam -> merhabaaliselam merhabaveliselam yapar. arada bosluk olmaz. bosluklu yazmak icin merhaba{\ ali, \ veli}selam yazmaliyiz
# {} -> {1..4} -> 1 2 3 4 / {1..10.2} -> 1 3 5 7 9 / {01..10} -> 01 02 03 04 05 06 07 08 09 10
# {} -> {a,b,c}{1..3} -> a1 a2 a3 b1 b2 b3 c1 c2 c3
# `` -> komut calistirir / ornek: deger=`date`
# '' -> yorumlamadan yazar -> yani icindeki `` ile yazilan komutlari calistirmayip oldugu gibi yazar
# "" -> yorumlayip yazar -> yani icindeki `` ile yazilan komutlari calistirir
