## ORM
__ORM__ -> Object Relational Mapping
- Java objeleri ile ilişkisel veri tabanı arasındaki bağlantıyı yönetimi sağlayan tekniktir.
- Ibatis, Castor, Hibernate, JDO(Java Data Objects), JPA(Java Persistence API) -> bazı ORM tool'ları

### JPA
JPA -> Java EE veya yeni adıyla Jakarta EE'nin bir bölümüdür.
* JPA'nın kendisi bir ürün/implemantasyon değildir. Bir dokümantasyon/abstracrion'dır.
* JPA'nın implemantasyonları:
	* EclipseLink
	* Hibernate (2 ürünü vardır: JPA implemantasyonu olan ürün ve Native Hibarnate ürünü.)
	* Open JPA
	* Data Nucleus

### Entity
Entity -> JPA açısından entity, kalıcı nesne ifadesi olarak geçer.
- Entity'lerin özellikleri:
	- Persistability (Kalıcı olma özelliği)
	- Identity (SQL'deki primary key -> entity veri tabanına kaydedilirken unique bir identity'e sahip olmalıdır.)
	- Transactionality (Örnek bir transiction akışı: 4 tane görev var. Bu görevlerden herhangi bir tanesinde sorun çıktığında rollback atılır(yani iptal edilir). Fakat sorun çıkmazsa akışa devam edilir.) -> Transaction'lar:
		1. Programatic transaction
		2. declarative transaction
	 Ayrıca transiction'da ACID kavramı vardır. (Atomicity,Consistent,Isolated,Durability)
	- Granularity (tanceikli olma, ortalama öğre boyutu) -> 
- java.lang.String gibi sınıflar entity olamaz. Wrapper sınıflar entity olamaz (String, Integer gibi sınıflar fine-grained(ince taneli) özelliğe sahiptir. Bu yüzden bunlar entity olamaz.). Uygulamamızdaki Business Domain Object'ler entity olarak kullanılabilir.
- An entity is a lightweight persistent domain object.
- lightweight(hafif, önemsiz) kavramı yazılım açısından az kod olması veya az sınıf olmasından ziyade kod değişikliği yapıldığında minimum etki ve minimum değişiklik yapma anlamlarına gelir.
- _Entity'lerin default constructor'ı olması gerekir._

## JPA
Konfigürasyonları (Metada/üstveri) Annotation veya XML ile yaparız.
Kullanacağımız sınıflar:
- EntityManagerFactory
- EntityManager
- EntityTransaction
- Persistence
- @PersistenceContext
- @PersistenceUnit
Persistence sınıfından EntityManagerFactory elde edebiliriz.
1 persistence -> N tane EntityManagerFactory
1 EntityManagerFactory -> N tane EntityManager 
1 EntityManagerFactory -> 1 PersistenceUnit tarafından konfigüre edilir.
EntityManager, Entity'ler üzerinde yaptığımız işlemlerden sorumludur. Ayrıca EntityManager'dan Entitytransaction'ları elde ederiz.
EntityManager tarafından yönetilen/managed edilen tüm Entity obje kümesine PersistenceContext adı verilir.
*persistence.xml dosyasında konfigürasyon bilgilerimiz yer alacak.*
PersistenceUnit -> Entity classlarının belirtildiği, veri tabanı bilgilerinin yer aldığı konfigürasyon bilgisidir.  **src** klasörü altındaki #META-INF klasörü altında yer almalıdır.

