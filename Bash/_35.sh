#! /bin/bash

sed -n '2p' < test # 2. satiri print'ler.
sed -n '1p;3p' < test # 1 ve 3. satiri print'ler.
head -7 < test # 1-7 line'lari verir.
