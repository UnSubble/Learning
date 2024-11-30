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