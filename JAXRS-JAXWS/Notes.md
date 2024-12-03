## JAX-RS

__REST__ -> 2000 yılındaki bir doktora tezinden gelmektedir. Representation State Transfer anlamına gelir.

__Addressability/Addressable Resources__ -> Erişim unique bir identifier ile ulaşılabilir olmalıdır. Her kaynak URI(Uniform Resource Identifier) ile adreslenebilir olmalıdır.

	`scheme://host:port/path?queryString#Fragment`
- __scheme__ -> kullanılan protokol, http/https, ftp...
- __host__ -> dns adı ya da ip adresi
- __port__ -> opsiyonel
- __path ve queryString__ -> verinin yolu ve sorgu dizemiz

__Representation Oriented__ -> XML, JSON gibi formatlar kullanılır. Bu formatlar aracılığı ile data exchange edilir. HTTP GET isteğinde bulunduğumuzda, ilgili kaynağın mevcut durumunu alırız.

__The Uniform, Constrained Interface__ -> Bu, URI'da "action" parametresi oluşturmayın ve web servisinizde sadece HTTP metodlarını kullanın anlamına gelir. (Yani parametreye göre akış kontrolü yapma.)

__HTTP GET__ -> Server'dan bir resource isteğinde bulunduğumuzda GET'i kullanırız.

__Idempotent__ -> Stateless olma durumudur. Aynı URI'ya farklı alanlardan GET isteğinde bulunsak bile her defasında aynı sonucu dönmesidir. GET doğası gereği idempotent özelliği gösterir.

__HTTP POST__ -> Non-idempotent özelliğe sahiptir. Her POST isteğinde sonuç değişir.

__HTTP PUT__ -> Update amacıyla tercih edilir. Put da get gibi idempotent özelliğe sahiptir. Sadece ilk istek etkili olur, sonraki aynı isteklerin hiçbir etkisi olmaz.

__HTTP DELETE__ -> Bu da tıpkı put gibidir. Idempotent özelliğe sahiptir ama aynı isteklerin ilki için bu durum geçerli değildir.

# JAX-WS
-> Java Api For Xml Web Services
	Sadece xml formatını destekler.
Farklı framework veya farklı diller de olsa ortak çalışma temel amaçtır.

__JAX-WS__, XML mesajlarında SOAP standardını kullanır.
__SOAP__ -> Simple Object Access Protocol

	- Metro Project, Glassfish
	- Apache CXF
	- Apache Axis2
	- JBossWS
	- IBM Websphere
	- Oracle Weblogic

SOAP mesajları complex yapıya sahiptir. Jax-ws bizim için soap mesajlarını oluşturur veya parse eder.

__WSDL__ -> web service description language
WSDL, XML tabanlı bir dokümandır. Web Service hakkındaki bilgiler bu yapıda yer almaktadır.
WSDL, bir service'e nasıl erişebiliriz, hangi operasyonları yapabiliriz, bunları tanımlar.

### WSDL Elements
__1-) Definitions:__ WSDL dokümanının root elemanıdır. Web service ismini tanımlar. targetNamespace, packageName ile ilişkilidir.
__2-) Type:__ Web service'te kullanılan data tiplerini belirtir. String, integer gibi tipler için tanımlamaya gerek yoktur. Daha kompleks tipler için tanımlanır.
__3-) Message:__ Web service'te tanımlı metotları ifade etmektedir. `<part>` elementi de dönüş ve input parametrelerini belirtir.
__4-) PortType:__ İçerisinde `<input>`, `<output>` elementleri yer alır. `<message>` elementindeki değer ile eşleşir. Soyut metotların tanımlarını içeren kümedir. `<portType name="[NAME]">` içerisindeki isim alanı interface, SEI'dir(Service endpoint interface). SEI içerisindeki(yani interface içerisindeki) tanımlı metotlar `<operation>` etiketi içerisinde yer almaktadır. 
	SEI üzerinde de `@WebService` annotation'ı kullanılır. 
	Metotlar üzerinde de `@WebMethod` annotation'ı kullanılır.
__5-) Binding:__ `<binding>` elementi içerisinde `<soap:binding>` gibi elementler yer almaktadır. style olarak rpc, document olabilir.
__6-) Service:__ SOAP adres elementi yer alır. Ayrıca location bilgisi, servis implementasyonunun ismi yer alır.
