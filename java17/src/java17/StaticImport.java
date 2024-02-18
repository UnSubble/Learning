package java17;

// import static pckg2.StaticImportSample // DOES NOT COMPILE
// static import pckg2.StaticImportSample // DOES NOT COMPILE
import static pckg2.StaticImportSample.variable; // eğer farklı bir paketteki aynı isimli değişken veya 
import static pckg2.StaticImportSample.method; // metotu da import etseydik. Compile sıkıntısı çıkardı.
import static pckg2.StaticImportSample.*; // LEGAL

public class StaticImport {
	
	public static void main(String[] args) {
		System.out.println(variable);
		method();
		// StaticImportSample.method(); // DOES NOT COMPILE
	}
	
}
