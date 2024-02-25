package java17;

public class Modules {

	public static void main(String[] args) {
		// module dosyaları module-info.java olarak adlandırlmak zorundadır.
		// bir module'de bir sürü paket yer alır.
		// daha iyi bir erişim sağlamak (module'ler ile sealed class gibi erişim belirleyebiliyoruz.)
		// güvenliği arttırır. performansı arttırır. (çünkü jdk'nin tamamı yerine belli bir kısmını kullanma-
		// sını söyleyebiliyoruz.)
		// bkz: moduleSamples project
		// javac --module-path <PATH buraya> -d <PATH buraya> 
											// feeding/zoo/animal/feeding/*.java feeding/module-info.java
			// --module-path yerine -p de kullanabiliriz.
		// module çalıştırmak için:
				// java --module-path <PATH> --module <MODULE NAME>/<PACKAGE NAME>.<Class NAME>
					// --module yerine de -m kullanabiliriz.
		
		// bir module birden çok paketi içerebilir.
		
		// örnek module:
		// module com.unsubble.main {
		//     exports com.unsubble.database to com.unsubble.proje3 // sadece proje3'e açar.
		//     exports com.unsubble.main;
		//     requires com.unsubble.proje2;
		//     requires transitive com.unsubble.proje3; // bu module'ü kullananlar dolaylı olarak proje2'yi
														// de kullanibilirler demektir.
		//     opens com.unsubble.proje4;  // proje4'ü reflection kullanarak erişmeye açar.
		//     opens com.unsubble.proje5 to com.unsubble.proje4; 
		//     uses com.unsubble.main.Main;   // java.util.ServiceLocater kullanmak için
		//     provides com.unsubble.main.Main with com.unsubble.proje1.MainImpl; //java.util.ServiceProvider
		// }																		// kullanmak için
		// ModuleSample yazılı örnek var.
		
		// open module com.unsubble.proje1 {
		// }
		
		// open module com.unsubble.proje1 {
		//     opens com.unsubble.proje1.main; // DOES NOT COMPILE // module'ü open'ladığımız için tekrar 
																	// open yapamayız.
		// }
	}			

}
