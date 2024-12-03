package _01.notes;

public class Notes {

}

// web service hizmetini farklı farklı clientler kullanabilir.
// bir client data'yı XML olarak isteyebilir, diğeri JSON, bir başkasi YAML formatında data'yı isteyebilir.
// bu durumda her bir response type için duplicate code yazmak yerine bunu flexible şekilde çözümleyebiliriz.

// client -> server ile iletişimi HTTP ile sağlamaktadır.
// client bir header ekler: Accept header'i
// client tercih ettiği header bilgisini Accept header'ı ile server'a gönderir.

// GET http://example.com/stuff
// Accept: application/xml, application/json

// bu durumda client server'dan data formatı olarak/cevap response olarak XML ya da JSON beklemektedir.
// eğer server bu formatı desteklemiyorsa bu durumda HTTP 406 Not Acceptable hatası döner.

// client'lar Accept header bilgisini vererek tercih sırasını berlirleyebilir.
// özelleşmiş olan öncelikli olacaktır.

// GET http://example.com/stuff
// Accept: text/*, text/html;level=1, */*, application/xml

// 1)text/html;level=1
// 2)application/xml
// 3)text/*
// 4)*/*

// GET http://example.com/stuff
// Accept: text/*;q=0.9, */*;q=0.1, audio/mpeg, application/xml;q=0.5

// q -> MIME type property
// 0.0-1.0 arasında değer alır.
// eğer tanımlı değilse default değer 1.0'dır.

// 1)audio/mpeg
// 2)text/*;q=0.9 (q büyük olduğu için)
// 3)application/xml;q=0.5
// 4)*/*;q=0.1