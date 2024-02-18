package java17;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Dates {
	public static void main(String[] args) {
		// bknz: java8.DateAndTimeAPI
		
		// LocalDate date = new LocalDate(); // DOES NOT COMPILE
		
		ZoneOffset.of("+02:00");
		// ZoneOffset.of("02:00"); // throws Exception
		// ZoneOffset.of("+2:00"); // throws Exception
		
		LocalTime time = LocalTime.of(3, 12, 45); // 03:12:45
		LocalTime truncated = time.truncatedTo(ChronoUnit.MINUTES); // 03:12 
		
		System.out.println(ZoneOffset.MAX);
		
		
		// OLD CLASSES
		
		Date date1 = new Date();
		Date date2 = new Date(1000); // Epoch time(1 ocak 1970 00:00:00)'ten 1 saniye sonrası
		
		System.out.println(System.currentTimeMillis());
		
		Calendar cal = Calendar.getInstance();		
		System.out.println(cal.getCalendarType());
		
		Date date3 = cal.getTime();
		System.out.println(date3);
		
		System.out.println(cal.get(Calendar.MONTH)); // 0'dan başlıyor.
		
		cal.add(Calendar.MONTH, 2);
		System.out.println(cal.getTime());
		
		Date date = new Date();
		System.out.println(DateFormat.getDateInstance().format(date));
		System.out.println(DateFormat.getDateInstance(DateFormat.SHORT).format(date));
		System.out.println(DateFormat.getDateInstance(DateFormat.MEDIUM).format(date));
		System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(date));
		System.out.println(DateFormat.getDateInstance(DateFormat.FULL).format(date));
		
		
	}
}
