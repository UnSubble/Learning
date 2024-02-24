package java17;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

	}
}
