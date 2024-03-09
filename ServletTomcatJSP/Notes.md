Servlet'lerin main metodu yoktur, bütün kontrol Servlet Container/Servlet Engine'ının sorumluluğu altındadır.  Gelen request eğer bir Servlet ya da JSP'yi tetikliyorsa bu durumda isteği Servlet Container/Servlet Engine karşılar:
- Böylelikle servlet'ler ile server arasındaki iletişimi sağlayarak port dinle, stream oluştur, http protokolüne göre kodu yaz, socket aç vs. gerekmez. 
- Lifecycle management: Servletlerin bütün yaşam döngüsü, container'ın sorumluluğu altındadır.  
- Multithread support: Her istek geldiğinde bir tane thread oluşur.
- JSP support: container jsp dosyalarını translate eder.
Application server -> içerisinde farklı modüllere/java ee yapılarına destek sağlar. Tomcat ise bunları sağlamaz. Sadece bir conatiner'dır.

### Handle Request
- son kullanıcı(client), servlet'i çağıran bir url'e tıklar.
- servlet container bu isteğe karşılık 2 tane obje oluşturur:
	- HttpServletRequest
	- HttpServletResponse
- Container yeni bir thread oluşturur. Service metodunu çağırır. 2. adımda oluşturulan req ve resp objeleri bu metoda geçer. 
- Gelen istek bir GET isteği ise doGet, POST ise doPost'a yönlendirme yapılır.
- İlgili metot çalışır ve istek karşılanır.
- Service metodu sonlanır. Thread sonlanır. Request ve response objeleri artık Garbage Collector tarafından temizlenebilir.

### Life Cycle
- Container, servlet class dosyalarını bulur, sonrasında loading işlemi yapılır.
- Servlet'ler:
	- Public olmak zorundadır.
	- Public no-arg constructor olmak zorundadır.
	- Genel olarak servletlerde constructor tanımlanmaz.
	- Constructor yerine init(initializer) metodu tercih edilir.
- Servlet initialize:
	- initialize mantığına birçok projede ihtiyacımız olacaktır.
	- Proje ayağa kalkarken, istek karşılanmadan önce, ilgili servlet ilk defa çalışmadan önce vs. bir konfigürasyon yapmak isteriz. Bu mantığa initialize mantığı denir.
	- init metodu lifecycle boyunca bir kez çalışır.
- Servicing:
	- Servlet oluşup initialize olduktan sonra artık istekler karşılanabilir. (handle request)
- Gelen her isteğe karşılık bir Thread oluşur. (Çok thread)
- Her servlet için sadece bir tane instance oluşur. (Bir obje)

### Servlet Config
- Her servlet'e karşılık bir servletconfig objesi oluşturulur.
- ServletConfig objesiyle web.xml dosyasında yer alan servletler için tanımlanmış init parameter bilgilerine erişim sağlayabiliriz. Bu parametrelerin okunması 1 kez yapılır.

### Scope Yaşam Alanları
- Request (Her bir farklı sekme için farklıdır.)
- Session (Her Browser ayrı bir session'dır. Browser'ın farklı sekmeleri ise aynı session'dır.)
- Context (Bütün proje kapsamında herhangi bir client erişim sağlayabilir.)

- __Attribute__ -> bu scope'larda yaşayan eklemiş olduğumuz objelerdir.

```
Object getAttribute(String name);
void setAttribute(String name, Object o);
void removeAttribute(String name);
Enumeration<String> getAttributeNames();
```
Bu metotlar üstteki 3 scope'taki ortak metotlardır.

### Session 
- HTTP protokolü stateless(durumsuz) bir protokoldür. Yani client server'a istekte bulunur, server isteği karşılar, bağlantı kapanır. 
- Session aynı client için birden fazla istekte devamlılık sağlamaktadır.
- __Session ID__: Container unique bir session id bilgisi oluşturur ve bunu response'a verir. Sonrasında ise client bir istekte bulunduğunda bu session id bilgisini server'a gönderir. Bu session id bilgisi özel header olan Cookie'ler yardımıyla taşınır.
-  HttpSession objesi oluşturmak, unique SessionID oluşturmak, Cookie objesi oluşturmak, Cookie'yi ilgili header olarak response'a vermek vs. işlemlerden Servlet Container sorumludur.

## JSP
__JSP__ -> Java Server Pages
__JSF__ -> Java Server Faces
bu 2 kavram birbirinden farklıdır ve ikisi de java ee ürünüdür.

JSP = web pages
Jsp sayfalarında java kodu yazabiliyoruz. (Aslında kendisi HTML file)

###### View Layer 
* Son kullanıcıya data'yı göster ya da son kullanıcıdan data al(form ile). Bunun dışındaki işlemleri view layer'da(JSP) yapma. 
* En çok yanlış yapılan hareket -> veritabanına bağlanmak
	Mvc'deki temel noktalardan bir tanesi bu katmanları ayrı tutmaktır. -> Seperation of concern

 JSP dosyaları, Servlet Container tarafından Servlet sınıflarına(.java) translate edilir. Sonrasında compile edilir(.class dosyaları oluşur).

JSP grameri -> JSP Scriptlet ile JSP sayfalarımızda java kodu yazabiliriz. genel formatı:
`                             <% java code %>                                `
JSP expression: Tarayıcıya direkt veri yazmak için kullanılır.
`                             <%=expression %>                               `
JSP Declaration:
`                             <%! public int methodName() >                  `
JSP Action:
`                             <jsp:action_name attribute=""/>                `
JSP Comment: Browser'da gözükmez.
`                             <%-- --%>                                      `
HTML Comment: Browser'da gözükür.
`                             <!-- -->                                       `
<%@ page
<%@ include
<%@ taglib

#### Attribute
- Çeşitli scope'lara bıraktığımız/eklediğimiz objelerdir.
	- Application(Context)
	- Session
	- Request
	- PageScope
- application.setAttribute("key", object); -> JSP'de böyle attribute eklenir.
- session.setAttribute("key", object);
- request.setAttribute("key", object);
- pageContext.setAttribute("key", obect); -> sadece JSP'de vardır. (Servlet'te yoktur.)






