package java17;

import java.util.Locale;

public class Localization {
	public static void main(String[] args) {
		Locale l1 = new Locale.Builder().setLanguage("en").setRegion("US").build();
		
		System.out.println(l1.getCountry()); // US
		System.out.println(l1.getDisplayCountry()); // Amerika Birleşik Devletleri
		System.out.println(l1.getDisplayCountry(l1)); // United States
		System.out.println(l1.getISO3Country()); // USA
		System.out.println(l1.getLanguage()); // en
		System.out.println(l1.getDisplayLanguage()); // İngilizce
		System.out.println(l1.getDisplayLanguage(Locale.FRANCE)); // anglais
		System.out.println(l1.getDisplayLanguage(l1)); // English
	}
}
