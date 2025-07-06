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
- Bu işlem tıpkı volume gibidir. Volume'den farkı ise volume'da eğer container'daki bağladığımız dizin doluysa ve volume dizini boşsa oradaki dosyalar volume dizinine kopyalanır. Tam tersi şeklinde ise tam tersi olur. İkisi de doluysa yine volume'daki kopyalanır. Bind mounts'ta ise yalnızca host'tan verdiğimiz dizin, container'ın dizinine kopyalanır.
- Ayrıca volume bir docker objesi iken bind mounts sadece path'tir.


## Network Driver Names
- bridge, none, host, overlay


## Docker CLI 101

__`docker container start [NAME]`->__  Durmuş olan container'ı başlatmamıza yarar.

__`docker container create [IMAGE_NAME]`->__  Yeni bir container yaratır.

__`docker container run [IMAGE_NAME]`->__ Start ve create'i bir arada yapar. Eğer container varsa create işlemi yapmaz.

__`docker container run --name [NAME] [IMAGE_NAME]`->__ İsim vererek run'lar.

__`docker container ls -a`->__ Tüm container'ları gösterir.

__`docker container run -p [CONTAINER_PORT]:[HOST_PORT]`->__ Port girmemize olanak tanır.

__`docker container stop [NAME]`->__ Container'ı durdurur.

__`docker ps -a`->__ docker container ls -a ile aynı görevi yapar.

__`docker container rm [NAME]`->__ Çalışmayan container'ı silmemizi sağlar.

__`docker container rm -f [NAME]`->__ Force'layarak container'ı silmemizi sağlar.

__`docker container run -d [IMAGE_NAME]`->__ Detach çalıştırır. (İçindeki shell'i bizim shell'e bağlamadan)

__`docker container exec -it [NAME] sh`->__ İlgili container'ın shell'ine bağlanmamıza yarar.

__`docker image ls`->__ Image'leri listeler.

__`docker image pull [NAME]`->__ İlgili image'ı çeker.

__`docker volume create [NAME]`->__ Volume oluşturur.

__`docker container run -it -v [VOLUME_NAME]:[TARGET_PATH] [CONTAINER_NAME] sh`->__ Container'ı başlatırken ilgili volume'ü container'ın içindeki ilgili dizine bağlar ve container'ın shell'ine bağlanır.  
__`docker container run -it -v [VOLUME_NAME]:[TARGET_PATH]:ro [CONTAINER_NAME] sh`->__ Volume'e bağlı dosyayı read-only olarak container'da shell ile başlatmamızı sağlar.

__`docker volume inspect [NAME]`->__ Volume'ün detaylarını gösterir. (Hangi path'i linklediğini vs.)

__`docker container run -it -v [LOCAL_PATH]:[TARGET_PATH] [CONTAINER_NAME] sh`->__ Bind Mounts yapmamızı sağlar.

__`docker container run --rm -it [IMAGE_NAME] sh`->__ İlgili image'ten container oluşturur ve ana işlem bittiği anda bu container'ı siler.

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

__`docker image build -t [ORG/REPO] -f [Dockerfile_PATH] [SRC_PATH]` ->__ src path root klasörü belirtmeye yarar. Örneğin kopyalama işleminde /app location'ını default root'ta arar. Fakat path olarak `.` girdiğimizde ./app location'ınında arama yapar.

## Dockerfile

__`FROM [IMAGE]:[TAG]`->__ hangi image'den image oluşturulacağını belirten komuttur.

__`RUN [COMMAND]`->__ shell'de çalıştırılacak komut için kullanılır. (image sırasında)

__`WORKDIR [DIR_PATH]`->__ tıpkı cd komutu gibidir ama klasör yoksa oluşturur ve gider.

__`COPY [SOURCE] [TARGET]`->__ kaynağı hedefe kopyalar.

__`EXPOSE [PORT]`->__ bu image'den oluşturulacak container'ların hangi portlar üstünden erişilebileceğini belirtir.

__`CMD [COMMAND]`->__ image'den container yarratıldığı zaman çalıştırılacak komut bununla belirtilir. (Komutumuzu `["ARG1", "ARG2", "ARG3", ...]` şeklinde girersek env variable'larını vb. durumları okuyamayız. Bu durumlarda `CMD ARG1 ARG2 ARG3 ...` şeklinde girmek gerekir.)

__`HEALTHCHECK [COMMAND]`->__ bu komut docker'a bir container'ın hala çalışıp çalışmadığını kontrol ettirir.

__`ADD [SOURCE]`->__ image'de bulunduğumuz dizine source'taki dosyaları eklememizi sağlar. (ADD'in COPY'den farkı copy sadece local'de çalışabiliyorken add ile uzaktaki bir yerden kopyalama yapılabilir, ayrıca ADD .tar.gz sıkıştırılmış dosyaları açarak kopyalar.)

__`LABEL [VAR]="[VALUE]"`->__  sadece dockerfile içinde değişken üretmek için kullanılır. `$[VAR]` şeklinde kullanılır.

__`ENV [VAR]="[VALUE]"`->__ environment variable oluşturur.

__`HEALTHCHECK --interval=[DURATION] --timeout=[DURATION] --start-period=[DURATION] --retries=[COUNT] CMD [COMMAND]`->__ interval: tekrar aralığını belirtir, timeout: cevabı bekleme süresi, start-period: başlangıç zaman aşımı. `command`'i de genellikle `|| exit 1` ile veririz.

__`ENTRYPOINT [COMMAND]`->__ CMD ile aynı işi yapar. Tek farkı container oluştururken çalışma şeklini override edemeyiz. İkisini de aynı anda kullanırsak CMD'yi ENTRYPOINT'in parametresi olarak alır. (ÖRN:```
			 ENTRYPOINT ["ping"]
			 CMD ["127.0.0.1"]```  
-> kısaca ping 127.0.0.1 çalışır. Bunu böyle yapmamızın sebebi ise container oluştururken CMD'yi ezerek ENTRYPOINT'e parametre gönderebilmektir.)

__`ARG [VAR]`->__ image oluştururken argument girmemizi sağlar. `${VAR}` şeklinde kullanılabilir. (Örn: `docker image build -t [NAME] --build-arg [VAR]=[VALUE]`)


## Docker Compose
- Image ve container'ları otomatize etmek için kullanılır.
- `Docker-compose.yml` veya `Docker-compose.yaml` dosyaları kullanılır.

__`docker-compose up` ->__ Otomatize ettiğimiz config'deki her şeyi yaratır ve çalıştırır.

__`docker-compose down` ->__ Otomatize ettiğimiz config'deki her şeyi siler.

__`docker-compose config` ->__ Aşağıdan yukarıya config dosyasının içeriğini gösterir.

#### Docker-compose.yaml 

__`version: "[VERSION]"` ->__ compose'un versiyonunu belirtir.

__`services:/volumes:/networks:/secrets:` ->__ top level başlıklardır.

Örn:

```
services:
	[CONTAINER_NAME]:
		image: [IMAGE_NAME]
		restart: always
		volumes:
			- [VOLUME_NAME]:[DEST_PATH]
			- [VOLUME_NAME]:[DEST_PATH]
			...
		environment:
			- [VAR]:[VALUE]
			- [VAR]:[VALUE]
			...
		networks:
			- [NETWORK_NAME]
			- [NETWORK_NAME]
			...
		depends_on:
			- [CONTAINER_NAME]
		ports:
			- "[PORT]:[PORT]"
	
	[CONTAINER_NAME]:
		build: [SRC_PATH]
		...	
		
volumes:
	[VOLUME_NAME]:

networks:
	[NETWORK_NAME]:
		driver: Bridge
```

- depends_on: diğer container'a bağımlı olmasını sağlıyoruz. Yani diğer container ayağa kalkmadan bu container ayağa kalkmaz. 
- build: image'ı vermek yerine Dockerfile verip image build ettirmek için kullanılır. (Dockerfile'ı değil de bulunduğu dizini vermek gerekir.)
- Docker-compose down komutu image ve volume'leri silmez!

## Docker Swarm
- Manager ve worker ilişkisi vardır. Bir docker makinesi manager olarak seçilir ve diğer makinelere işler verir.
- Manager'lar da default olarak worker'dır!

__`docker swarm init --addvertise-addr [MANAGER_IP_ADDR]` ->__ swarm modu açabilmek için kullanılır.

__`docker swarm join-token manager` ->__ manager node'dayken bir docker node'unu manager yapmamız için gereken komutu verir.

__`docker swarm join-token worker` ->__ manager node'dayken bir docker node'unu worker yapmamız için gerek komutu verir.

__`docker node ls` ->__ swarm cluster'daki node'ları listeler.

__`docker service create --name [NAME] --replicas=[COUNT] [IMAGE_NAME]` ->__ bir servis oluşturur ve bu serviste replicas kadar container oluşturur. Bunları worker'lara uygun bir şekilde dağıtır. 

__`docker service scale [SERVICE_NAME]=[COUNT]` ->__ replicas sayısını değiştirmemizi sağlar.

__`docker service update --update-delay [DURATION] --update-parallelism [COUNT] --image [IMAGE_NAME] [NAME]` ->__ servisi kesintiye uğramadan image'ı update edebilmek için kullanılır.

__`docker node rollback [NAME]` ->__ bir önceki update'i geri alır.

## Docker Secret
- Dosyaları şifrelemeye yarar.

__`docker secret create [NAME] [SRC_PATH]` ->__ şifreli obje oluşturmaya yarar.

__`echo [VALUE] | docker secret create [NAME] -` ->__ terminalden şifreli obje oluşturmaya yarar.

__`docker service create --secret [SECRET_NAME] [NAME] [IMAGE_NAME]` ->__ servis oluştururken secret objelerimizi atamaya yarar.

## Docker Stack
- Docker compose yaml dosyasını kullanarak docker swarm servisleri yaratabiliriz. Buna docker stack denir.

__`docker stack deploy -c [YAML_PATH] [NAME]` ->__ stack ile service oluşturmak için kullanılır.

#### Docker-compose.yaml

```
services:
	[CONTAINER_NAME]:
		image: [IMAGE_NAME]
		deploy:
			replicas: [COUNT]
			update_config:
				parallelism: [COUNT]
				delay: [DURATION]
				order: stop-first
		environment:
			- [VAR]:[VALUE]
			- [VAR]:[VALUE]
			...
		networks:
			- [NETWORK_NAME]
			- [NETWORK_NAME]
			...
		depends_on:
			- [CONTAINER_NAME]
		ports:
			- "[PORT]:[PORT]"
	
	[CONTAINER_NAME]:
		...	

networks:
	[NETWORK_NAME]:
		driver: overlay
```