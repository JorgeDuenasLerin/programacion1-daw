import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class PruebaDeSet {

	public static void main(String[] args) {
		Comparator<String> comparator = new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				System.out.printf("Comparando %s con %s\n", o1, o2 );
				return o2.toLowerCase().compareTo(o1.toLowerCase());
			}
			
		};
		
		
		Set<String> set = new TreeSet<String>(comparator);
		
		String[] cosas = new String[]{  "hola", "que", "tal", "hola", "yo", "me", "llamo", "earl", "llamo", "Hola"};
		
		for (String cosa : cosas) {
			System.out.printf("Insertando %s\n", cosa);
			set.add(cosa);
		}
		
		String suma = "";
		for (String i: set) {
			suma += i;
		}
		
		System.out.println(suma);
	}
}
