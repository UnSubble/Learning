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


# !!!
- Annotation'ları ilgili property veya property getter'ının üzerine koyabiliriz. Setter'a koymak mantıksız ve anlamsız olacaktır.
- Enum'lar kaydedilirken ordinal sırasına göre kaydedilirler. Bunu değiştirmek için `@Enumarated` annotation'ını kullanırız.
- primary key'i autoincrement yapmak için -> AUTO, TABLE, SEQUENCE, IDENTITY yaklaşımları kullanılabilir. (`@GeneratedValue` annotation'ı ile)
	- `@GeneratedValue(strategy = GenerationType.AUTO)` -> SEQUENCE adında tablo oluşur. Kolonları SEQ_NAME ve SEQ_COUNT şeklindedir. Satırı da default allocation 50 şeklindedir.
	- `@GeneratedValue(strategy = GenerationType.TABLE)` -> SEQUENCE adında tablo oluşur. Satırı SEQ_GEN_TABLE şeklindedir.
	- `@GeneratedValue(strategy = GenerationType.SEQUENCE)` -> Her veri tabanında yoktur. Bunun yerine AUTOINCREMENT kavramı olabilir. 
	- `@GeneratedValue(strategy = GenerationType.IDENTITY)` -> Auto increment'tir.
- Bir Entity Relationship için:
	1. Role -> bir ilişkide 2 tarafın varlığı gerekmektedir. Her ilişki için 2 tane Entity vardır.
	2. Directionality -> Unidirectional(bir ilişkide, 2 entity'den sadece birisi diğerini gösteriyorsa/point ediyorsa bu durumda unidirectional'dır) veya BiDirectional(birbirlerini gösteriyorsa bidirectional'dır)
	3. Cardinality -> (kelime anlamı: önemli, asıl, nicelik) Bir Employee sadece 1 departmanda çalışabilir. 1 departmanda N tane employee olabilir (One to one -> `@OneToOne`). /// 1 Employee N tane projede çalışabilir. 1 projede N tane employee olabilir. (Many to one -> `@ManyToOne`) /// (`@ManyToMany`) /// (`@OneToMany`)
	4. Ordinality/Optionality -> Zorunlu/mandotary ya da seçimli/optional olup olmaması ile ilgili bir kavramdır.
	 - Birbiri ile ilişkili iki değerin ikisinde de `@OneToOne` kullanırsak hala unidirectional olur. Birbiriyle ilişkisel yapmak için `@OneToOne(mappedBy = "İLİŞKİLİ_OLDUĞU_DEĞİŞKEN")` kullanmamız gerekir. İşte o zaman bidirectional bir ilişki olmuş olur. İlişkinin sahibi(owning side) mappedBy yazmadığımız taraftır. mappedBy'ın foreign key'i burada yer alır. Karşı taraf(inverse side) mappedBy yazdığımız taraftır. Burada ekstra column oluşmaz.
	 - `@ManyToMany` veya `@OneToMany` ilişkilerde colloction vermemiz lazım. Çünkü tek bir single object yetmez.  Ayrıca yine mappedBy kullanmazsak unidirectional olur.
- `@Embeddable` embedded obje oluşturur. Bu objeler için entity tag'ı kullanılmaz. Aynı zamanda primary key olmadığı için `@Id` de kullanılmaz. Embedded objeler başka entity'lere gömülüyor.
- DAO katmanında sadece veri tabanına bağlanılır. Service katmanında ise bu bağlantıdan önce yapılacak olan kontroller yapılır.

## JPQL
Java Persistence Query Language
- SQL'e benzer fakat bazı noktalarda farklılıklar vardır.
-  En basit JPQL sordusu:
	`SELECT e from Employee e` -> burada Employee entity'nin kendisi.
	