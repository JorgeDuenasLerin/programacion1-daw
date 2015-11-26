import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerUnFichero {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		System.out.println("Dime un nombre de fichero:");
		String nombreFichero = in.nextLine();
		
		
		Scanner fichero = new Scanner( new File(nombreFichero) );
		
		while( fichero.hasNextLine() ){
			System.out.println( fichero.nextLine() );
		}
		
	}
}
