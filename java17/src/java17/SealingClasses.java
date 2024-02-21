package java17;

public class SealingClasses {
	// java 17 ile geldi.
	// Sadece belirlediği class'lar bu sınıfı extends edebilir.
	// sealed class'la permit'lediği class'lar aynı pakette yer almalıdır.
}

sealed interface Animal2 permits Bear2 {
}

sealed class Bear2 implements Animal2 permits Kodiak, Panda { // sealed keyword'ü hem class hem 
}										   // interface'lerde kullanılabilir. permits keyword'ü hangi 
										   // sınıf/interface'lerin kendisini extends edeceğini belirtmek 
										   // için kullanılır.

final class Kodiak extends Bear2 { // sealed class'ı kalıtan class final/sealed/non-sealed olmalı.
}

non-sealed class Panda extends Bear2 { // non-sealed keyword'ü permits kısmında belirtilmeyen sınıfların da
}									   // kendisini extends edebileceğini söylemek için kullanılır.
									   // interface'lerde final kullanamayacağımız için sadece non-sealed 
									   // keyword'ünü alır.

class SubPanda extends Panda {
}



abstract sealed class Wolf permits Timber, Nimber {
}

final class Timber extends Wolf {
}

non-sealed abstract class Nimber extends Wolf {
}

// final class MyWolf extends Wolf {} // DOES NOT COMPILE
// class sealed Frog permits GlassFrog // DOES NOT COMPILE çünkü sealed keyword'ü class'tan önce gelmelidir.



sealed class Snake { // Eğer aynı dosyadalarsa permits keyword'ü ile kimlerin extends edeceğini belirtmeye
														// gerek yoktur. (iç içe olurlarsa da gerek yoktur.)
}

final class Corba extends Snake {                                                 
}