import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class QuitarDuplicados {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Set<String> conjunto = new TreeSet<String>();
		String linea = in.nextLine();
		while( !linea.equals("fin") ){
			
			conjunto.add(linea);
			linea = in.nextLine();
		}
		
		for( String s: conjunto ){
			System.out.println(s);
		}
	}
}
