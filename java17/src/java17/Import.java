package java17;

public class Import {
	public static void main(String[] args) {
		// elimizde aynı isimli 2 sınıf var. Bu sınıflardan bir a paketinde
		// diğeri b paketinde. eğer:
		
		// import a.*;
		// import b.<Class İsmi>
		// böyle yazarsak b'deki öncelikli hale gelir.
		
		// import b.<Class İsmi>
		// import a.*
		// böyle yazarsak yine b'deki öncelikli hale gelir.
		
		// ikisi için de * kullanırsak veya direkt class ismi ile import edersek hata alırız.
	}
}
