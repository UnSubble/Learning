#### IOC (Inversion of Control)
- Bağımlılıkların veya objelerin oluşturulması ve yönetilmesi işini developerdan alıp external olarak halletmesidir.

#### Dependency Injection
- Dependency injection bir IOC tekniğidir.
- Reduced glue code (yapışık kodları azaltmak)
- Uygulamanın konfigürasyonunu basitleştirmek
- Kodun test edilebilir özelliğine katkı sağlar

#### Code to Interface Principle
```java
List<String> good = new ArrayList<>(); // -> code to interface
ArrayList<String> bad = new ArrayList<>();
```
