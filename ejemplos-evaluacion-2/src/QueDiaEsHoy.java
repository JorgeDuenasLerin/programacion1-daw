import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class QueDiaEsHoy {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' YYYY 'a las' HH:mm");
		
		Date fecha1 = c.getTime();
		System.out.println( df.format(fecha1));
		
		c.add( Calendar.DATE, 120);
		c.add( Calendar.HOUR, 110);
		Date fecha2 = c.getTime();
		System.out.println( df.format(fecha2));
		
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR,2016);
		c2.set(Calendar.MONTH,Calendar.MARCH);
		c2.set(Calendar.DAY_OF_MONTH, 26);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		
		for( int i = 0 ; i < 3*24*2 ; i++ ){
			DateFormat df2 = new SimpleDateFormat( "HH:mm dd-MM-YYYY zzzzzz");
			System.out.println(df2.format(c2.getTime()));
			c2.add(Calendar.MINUTE, 30);
		}
		
		
	}
}
