# Docker


## Image
- __Docker Image:__ Bir uygulamanın ve çalışması için gereken ek kütüphane ve yazılımların paketlenmiş haline docker image denir. Image için kernel'e gerek yoktur. Çünkü container'lar üzerinde çalıştığı işletim sisteminin kernel'ını kullanırlar.
- Image bir şablondur.
- Image içerisinde guest operating system gereklidir.


## Container
- __Container:__ Image şablonundan istediğimiz kadar container yaratabiliriz. Image ana şablondur. Container ise bu şablondan oluşan çalışan bir kopyadır.


## Volume
- Container'ların veri depoları kendi yazılabilir katmanı üzerindedir. Bu yüzden container silindiğinde yazılabilir katmanındaki veriler de kaybolur. Volume'lar ile bu katmandaki verileri host makineye bağlar (Yani volume buradaki path oluyor, ':' işaretinden sonra verdiğimiz path ise container'ın içinde oluşturulacak path oluyor.). Böylelikle veriler container silinse bile kaybolmaz, saklanır.


## Bind Mounts
- Bu işlem tıpkı volume gibidir. Volume'den farkı ise volume'da eğer container'daki bağladığımız dizin doluysa ve volume dizini boşsa oradaki dosyalar volume dizinine kopyalanır. Tam tersi şeklinde ise tam tersi olur. İkisi de doluysa yine volume'daki kopyalanır. Bind mounts'ta ise yalnızca host'tan verdiğimiz dizin container'ın dizinine kopyalanır.
- Ayrıca volume bir docker objesi iken bind mounts sadece path'tir.


## Network Driver Names
- bridge, none, host


## Docker CLI 101

__`docker container start`->__  Durmuş olan container'ı başlatmamıza yarar.

__`docker container create`->__  Yeni bir container yaratır.

__`docker container run`->__ Start ve create'i bir arada yapar. Eğer container varsa create işlemi yapmaz.

__`docker container run --name`->__ İsim vererek run'lar.

__`docker container ls -a`->__ Tüm container'ları gösterir.

__`docker container run -p [CONTAINER_PORT]:[HOST_PORT]`->__ Port girmemize olanak tanır.

__`docker container stop`->__ Container'ı durdurur.

__`docker ps -a`->__ docker container ls -a ile aynı görevi yapar.

__`docker container rm`->__ Çalışmayan container'ı silmemizi sağlar.

__`docker container rm -f`->__ Force'layarak container'ı silmemizi sağlar.

__`docker container run -d`->__ Detach çalıştırır. (İçindeki shell'i bizim shell'e bağlamadan)

__`docker container exec -it [NAME] sh`->__ İlgili container'ın shell'ine bağlanmamıza yarar.

__`docker image ls`->__ Image'leri listeler.

__`docker image pull [NAME]`->__ İlgili image'ı çeker.

__`docker volume create [NAME]`->__ Volume oluşturur.

__`docker container run -it -v [VOLUME_NAME]:[TARGET_PATH] [CONTAINER_NAME] sh`->__ Container'ı başlatırken ilgili volume'ü container'ın içindeki ilgili dizine bağlar ve container'ın shell'ine bağlanır.  

__`docker volume inspect [NAME]`->__ Volume'ün detaylarını gösterir. (Hangi path'i linklediğini vs.)

__`docker container run -it -v [LOCAL_PATH]:[TARGET_PATH] [CONTAINER_NAME] sh`->__ Bind Mounts yapmamızı sağlar.


## Docker CLI 102

__`docker network ls`->__ Yüklü olan network'leri gösterir.

__`docker network inspect [NAME]`->__ Network'ün detaylarını gösterir.

__`docker container run --net [NETWORK_NAME] [NAME]`->__ Container'ın network'ünü belirleyerek run'lar.

__`docker network create [NAME]`->__ Yeni bir bridge network yaratmamızı sağlar.

__`docker network create --driver=[DRIVER_NAME] [NAME]`->__ Yeni bir network yaratmamızı sağlar.

__`docker network create --driver=[DRIVER_NAME] --subnet=10.10.0.0/16 --ip-range=10.10.10.0/24 --gateway=10.10.10.10 [NAME]`->__ subnet: bridge network'ün subnet'i, ip-range: bu network ile oluşturulacak container'ların ip aralığı

__`docker attach [CONATINER_NAME]`->__ halihazırda çalışan container'a bağlanmamıza yarar.

__`docker network connect [NETWORK_NAME] [CONTAINER_NAME]`->__ Container'ı custom network'lerimize bağlamayı sağlar.

__`docker network disconnect [NETWORK_NAME] [CONTAINER_NAME]`->__ Container'ın custom network'lerimizle bağlantısını kesmeyi sağlar.

__`docker logs [CONTAINER_NAME]`->__ container'da oluşan log'ları gösterir.

__`docker top [CONTAINER_NAME]`->__ container'da çalışan proccess'leri gösterir.

__`docker stats [CONTAINER_NAME]`->__ memory, cpu stat'larını gösterir.

__`docker run --memory=[SIZE] [CONTAINER_NAME]`->__ memory limit'i ekleyebiliriz. (100m -> 100 megabytes, 1g -> 1 gigabyte)

__`docker run --memory=[SIZE] --memory-swap=[SIZE+EXTRA_SIZE] [CONTAINER_NAME]`->__ memory limit'ini aşarsa çökmemesi için ek olarak girdiğimiz alanı kullanmaya başlar. (ekstra üzerine eklenmez, o alan kadar yeri kullanır. Örn: 100 mb verdiysek swap alanını 100'den fazla vermemiz gerekir.)

__`docker run --cpus=[COUNT] [CONTAINER_NAME]`->__ cpu core limit'ini belirler.

__`docker run ---env [VARIABLE_NAME]=[VALUE] [CONTAINER_NAME]`->__ container içinde environment variable oluşturmamıza sağlar. (Eğer value girmezsek host'taki value'yu kullanır.)

__`docker run ---env-file [FILE_PATH] [CONTAINER_NAME]`->__ bir dosyadan environment variable'ları çeker.

__`docker image build -t [ORG/REPO] -f [Dockerfile_PATH]` ->__ Dockerfile dosyası ile image yaratır. -f zaten default olarak Dockerfile olduğu için ekstradan belirtmeye gerek yok.

__`docker image build -t [ORG/REPO]` ->__ üstteki kısa hali.

__`docker image build -t [ORG/REPO] -f [Dockerfile_PATH] [SRC_PATH]` ->__ src path de root klasörü belirtmeye yarar. Örneğin kopyalama işleminde /app location'ını default root'ta arar. Fakat path olarak `.` girdiğimizde ./app location'ınında arama yapar.

## Dockerfile

__`FROM [IMAGE]:[TAG]`->__ hangi image'den image oluşturulacağını belirten komuttur.

__`RUN [COMMAND]`->__ shell'de çalıştırılacak komut için kullanılır.

__`WORKDIR [DIR_PATH]`->__ tıpkı cd komutu gibidir ama klasör yoksa oluşturur ve gider.

__`COPY [SOURCE] [TARGET]`->__ kaynağı hedefe kopyalar.

__`EXPOSE [PORT]`->__ bu image'den oluşturulacak container'ların hangi portlar üstünden erişilebileceğini belirtir.

__`CMD [COMMAND]`->__ image'den container yarratıldığı zaman çalıştırılacak komut bununla belirtilir.

__`HEALTHCHECK [COMMAND]`->__ bu komut docker'a bir container'ın hala çalışıp çalışmadığını kontrol ettirir.

__`ADD [SOURCE]`->__ image'de bulunduğumuz dizine source'taki dosyaları eklememizi sağlar.

