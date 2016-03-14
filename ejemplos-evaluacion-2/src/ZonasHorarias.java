import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ZonasHorarias {
	public static void main(String[] args) {

		String[] availableIDs = TimeZone.getAvailableIDs();
		Locale[] availableLocales = Locale.getAvailableLocales();
		for (String tzId : availableIDs) {
			for (Locale locale : availableLocales) {
				TimeZone tz = TimeZone.getTimeZone(tzId);
				DateFormat df = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' YYYY 'a las' HH:mm",locale);
				df.setTimeZone(tz);
				System.out.printf("%s: %s: %s\n", tzId, locale, df.format(new Date()));
			}
		}

	}
}
