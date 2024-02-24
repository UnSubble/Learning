package java17;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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
		
		var localeTr = new Locale("tr", "TR");
		var money = 1.23;
		var today = LocalDate.now();
		
		Locale.setDefault(new Locale("en", "US"));
		
		System.out.println(NumberFormat.getCurrencyInstance().format(money)); // $1.23
		System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(today));
																					// February 24, 2024
		System.out.println(localeTr.getDisplayLanguage()); // Turkish
		
		Locale.setDefault(Locale.Category.DISPLAY, localeTr);
		
		System.out.println(NumberFormat.getCurrencyInstance().format(money)); // $1.23
		System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(today));
																					// February 24, 2024
		System.out.println(localeTr.getDisplayLanguage()); // Türkçe
		
		Locale.setDefault(Locale.Category.FORMAT, localeTr);
		
		System.out.println(NumberFormat.getCurrencyInstance().format(money)); // ₺1,23
		System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(today)); 
																					// 24 Şubat 2024
		System.out.println(localeTr.getDisplayLanguage()); // Türkçe
		
		
	}
}
