#! /bin/bash

# INPUT -> Klavye < (0)
# OUTPUT -> Ekran(standard output) > (1)
# OUTPUT -> Ekran(standard error) 2> (2)

# komut > dosya (Komutun ciktisi dosyaya yazilir) (yani write)
# komut >> dosya (Komutun ciktisi dosyanin sonuna yazilir) (yani append)
# komut < dosya (Komutun girdisi dosyadan okunur)
# komut >| dosya (noclobber set edilmis olsa dahi komut ciktisi dosyaya yazdirilir)
# komut 2> dosya (komutun hatalari dosyaya yazilir)
# komut > dosya 2>&1 (komutun ciktisi ve hatalari ayni dosyaya yazdirilir) (buradaki &1 regEx ifadesidir)
# komut &> dosya (komutun ciktisi ve hatalari ayni dosyaya yazdirilir)
# komut &>> dosya (komutun ciktisi ve hatalari ayni dosyanin sonuna eklenir)
# komut > dosya1 2> dosya2 (komutun ciktisi dosya1'e hatalari dosya2'ye yazdirilir)
