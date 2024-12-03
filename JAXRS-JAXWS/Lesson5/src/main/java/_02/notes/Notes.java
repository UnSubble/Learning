package _02.notes;

public class Notes {

}

// HATEOAS -> hypermedia as the engine of application state

// bir web sitesine girdiğimizde birçok link yer almaktadir.
// bunların tam adresini ezberlemeyiz. siteye bir kere girdiğimizde
// linklere tıklayarak istediğimiz content'i buluruz.

// HATEOAS kavramı da bu mantıktan yola çıkmaktadır.
// RESTFul web service'lerinin extra olarak bilgi sunmaso ve böylece tek bir
// giriş noktasından sonra client/istemcinin kolayca uygulamayı kullanmasını
// hedefler. daha az dokümantasyon.

// HATEOAS bir RESTFul kısıtlamasıdır/constraint

// https://www.ibm.com/developerworks/library/x-atom10/index.html
// <?xml version="1.0" encoding="UTF-8"?>
// <feed xmlns="http://www.w3.org/2005/Atom" xml:base="http://www.example.org/">
// <id>http://www.example.org/pictures</id>
// <title>My Picture Gallery</title>
// <updated>2005-07-15T12:00:00Z</updated>
// <author>
//    <name>James M Snell</name>
// </author>
// <entry>
//    <id>http://www.example.org/entries/1</id>
//    <title>Trip to San Francisco</title>
//    <link href="/entries/1" />
//    <updated>2005-07-15T12:00:00Z</updated>
//    <summary>A picture of my hotel room in San Francisco</summary>
//    <content type="image/png" src="/mypng1.png" />
// </entry>
// <entry>
//    <id>http://www.example.org/entries/2</id>
//    <title>My new car</title>
//    <link href="/entries/2" />
//    <updated>2005-07-15T12:00:00Z</updated>
//    <summary>A picture of my new car</summary>
//    <content type="image/png" src="/mypng2.png" />
// </entry>
// </feed>

// https://developer.paypal.com/docs/api/overview/#hateoas-links