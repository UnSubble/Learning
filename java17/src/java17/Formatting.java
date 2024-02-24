package java17;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Stream;

public class Formatting {
	public static void main(String[] args) {
		double d = 1234.567;
		NumberFormat f1 = new DecimalFormat("###,###,###.0");
		System.out.println(f1.format(d)); // 1.234,6
		
		NumberFormat f2 = new DecimalFormat("000,000,000.0000"); // eksik basamağı 0 ile doldurur.
		System.out.println(f2.format(d)); // 000.001.234,5670
		
		NumberFormat f3 = new DecimalFormat("Your balance $#,###,###.##");
		System.out.println(f3.format(d)); // Your balance $1.234,57
		
		NumberFormat f4 = new DecimalFormat("Your balance $#######.0000");
		System.out.println(f4.format(d)); // Your balance $1234,5670
		
		LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // 2022-10-20
		
		LocalDateTime datetime = LocalDateTime.now();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
		System.out.println(fmt.format(datetime)); // Şubat 24, 2024 at 08:01
	
		// MMM -> ay kısaltması (eyl, ağu gibi)
		// ' -> kaçış karakteri ('araya bir şeyler yazabilirsin') 
							// (tek tırnak işareti için de 'a''s' -> "a's")
		// E -> gün ismi
		// dd -> ayın günü
		// DD -> yılın günü
		// MM -> ay (1-2-3-4...)
		// MMMM -> ay ismi
		// h -> saat (12'lik)
		// H -> saat (24'lük)
		// s -> saniye
		// S -> milisaniye
		// a -> p.m/a.m
		// z -> time zone name
		// Z -> time zone offset
		
		Date dateMutable = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(sdf.format(dateMutable)); // 24/02/2024

		
		
		double attendeesPerYear = 3200000.234;
		double attendeesPerMonth = attendeesPerYear / 12;
		
		NumberFormat tr = NumberFormat.getInstance();
		System.out.println(tr.format(attendeesPerMonth)); // 266.666,686
		
		NumberFormat us = NumberFormat.getInstance(Locale.US);
		System.out.println(us.format(attendeesPerMonth)); // 266,666.686
		
		NumberFormat de = NumberFormat.getInstance(Locale.GERMANY);
		System.out.println(de.format(attendeesPerMonth)); // 266.666,686
		
		NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		System.out.println(ca.format(attendeesPerMonth)); // 266 666,686
		
		int maxFractionDigits = tr.getMaximumFractionDigits();
		int minFractionDigits = tr.getMinimumFractionDigits();
		
		System.out.println("maxFractionDigits: " + maxFractionDigits); // 3
		System.out.println("minFractionDigits: " + minFractionDigits); // 0
		
		double num = 123.456789;
	 	NumberFormat trClone = (NumberFormat) tr.clone();
	 	System.out.println("before: " + trClone.format(num)); // 123,457
	 	trClone.setMaximumFractionDigits(6);
	 	System.out.println("after: " + trClone.format(num)); // 123,456789
	 	trClone.setMaximumIntegerDigits(2);
	 	System.out.println(trClone.format(num)); // 23,456789
	 	
	 	
	 	double price = 48;
	 	
	 	NumberFormat trCurrency = NumberFormat.getCurrencyInstance();
		System.out.println(trCurrency.format(price)); // ₺48,00
		
		NumberFormat usCurrency = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(usCurrency.format(price)); // $48.00
		
		NumberFormat deCurrency = NumberFormat.getCurrencyInstance(Locale.GERMANY);
		System.out.println(deCurrency.format(price)); // 48,00 €
		
		
		double successRate = 0.806;
		
		NumberFormat trP = NumberFormat.getPercentInstance();
		System.out.println(trP.format(successRate)); // %81
		
		NumberFormat usP = NumberFormat.getPercentInstance(Locale.US);
		System.out.println(usP.format(successRate)); // 81%
		
		NumberFormat deP = NumberFormat.getPercentInstance(Locale.GERMANY);
		System.out.println(deP.format(successRate)); // 81 %
		
		
		String str = "40.45";
		String str2 = "50,53";
		String str3 = "60ABC";
		
		NumberFormat trParse = NumberFormat.getInstance();
		try {
			System.out.println(trParse.parse(str)); // 4045
			System.out.println(trParse.parse(str2)); // 50.53
			System.out.println(trParse.parse(str3)); // 60
		} catch (ParseException e) {
		}
		
		NumberFormat usParse = NumberFormat.getInstance(Locale.US);
		try {
			System.out.println(usParse.parse(str)); // 40.45
			System.out.println(usParse.parse(str2)); // 5053
			System.out.println(usParse.parse(str3)); // 60
		} catch (ParseException e) {
		}
		
		NumberFormat frParse = NumberFormat.getInstance(Locale.FRANCE);
		try {
			System.out.println(frParse.parse(str)); // 40
			System.out.println(frParse.parse(str2)); // 50.53
			System.out.println(frParse.parse(str3)); // 60
		} catch (ParseException e) {
		}
		
		NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
		numberFormat.setParseIntegerOnly(true);
		try {
			System.out.println(numberFormat.parse(str)); // 40
		} catch (ParseException e) {
		}
		
		
		String income = "$92,807.99";
		
		NumberFormat usCurr = NumberFormat.getCurrencyInstance(Locale.US);
		try {
			System.out.println(usCurr.parse(income)); // 92807.99
		} catch (ParseException e) {
		}
		
		
		Stream<NumberFormat> stream = Stream.of(NumberFormat.getCompactNumberInstance(),
				NumberFormat.getCompactNumberInstance(Locale.getDefault(), Style.SHORT),
				NumberFormat.getCompactNumberInstance(Locale.getDefault(), Style.LONG),
				NumberFormat.getCompactNumberInstance(Locale.US, Style.SHORT),
				NumberFormat.getCompactNumberInstance(Locale.US, Style.LONG));
		stream.forEach((x) -> System.out.println(x.format(7123456))); // 7 Mn
																	  // 7 Mn
																	  // 7 milyon
																	  // 7M
																	  // 7 million
	}
}
