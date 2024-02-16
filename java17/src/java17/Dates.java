package java17;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
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
	}
}
