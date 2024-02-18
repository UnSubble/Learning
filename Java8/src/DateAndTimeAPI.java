import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateAndTimeAPI {
	public static void main(String[] args) {
		// Localdate, date'in aksine immutable'dır.
		LocalDate date = LocalDate.now();
		LocalDate date1 = LocalDate.ofYearDay(2010, 60);
		System.out.println(date1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		
		ZoneId defaultZone = ZoneId.systemDefault();
		System.out.println(defaultZone);
		
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		
		Instant instant = Instant.now(); // UTC = 0 olarak tutar.
		System.out.println(instant);
		
		// Period sınıfı localDate ile ilgilenir. Duration ise localTime ile.
		Period period = Period.ofYears(467);
		System.out.println(period);
		date = date.plus(period);
		System.out.println(date);
		Period p = Period.between(date1, date);
		System.out.println(p);
		ChronoUnit unit = ChronoUnit.DAYS;
		System.out.println(unit.between(date1, date));
	}
}
