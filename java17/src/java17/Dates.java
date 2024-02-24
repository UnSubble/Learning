package java17;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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
		
		LocalDateTime dt = LocalDateTime.of(2022, Month.APRIL, 20, 15, 12, 35);
		Locale us = new Locale("en","US");
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(dtf.withLocale(us).format(dt)); // 4/20/22
		System.out.println(dtf.format(dt)); // 20.04.2022
		dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		System.out.println(dtf.withLocale(us).format(dt)); // 3:12 PM
		System.out.println(dtf.format(dt)); // 15:12
		dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT);
		System.out.println(dtf.withLocale(us).format(dt)); // 4/20/22, 3:12 PM
		System.out.println(dtf.format(dt)); // 20.04.2022 15:12
		
		ZonedDateTime zdt = ZonedDateTime.of(dt, ZoneId.of("Europe/Istanbul"));
		
		dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println(dtf.withLocale(us).format(zdt)); // April 20, 2022
		System.out.println(dtf.format(zdt)); // 20 Nisan 2022
		dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);
		System.out.println(dtf.withLocale(us).format(zdt)); // 3:12:35 PM TRT
		System.out.println(dtf.format(zdt)); // 15:12:35 TRT
		dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.LONG);
		System.out.println(dtf.withLocale(us).format(zdt)); // April 20, 2022 at 3:12:35 PM TRT
		System.out.println(dtf.format(zdt)); // 20 Nisan 2022 15:12:35 TRT
	}
}
