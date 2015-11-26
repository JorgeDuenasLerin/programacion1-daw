import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Excepciones {

	public int primerNumeroNegativo(int[] nums) {
		for (int i : nums) {
			if (i < 0)
				return i;
		}
		throw new IllegalArgumentException("No hay negativo");
	}

	 public static int primerNumeroNegativo(String fichero) throws FileNotFoundException {
		Scanner in = new Scanner(new File(fichero));
		for (int i = in.nextInt(); in.hasNextInt(); i = in.nextInt()) {
			if (i < 0)
				return i;
		}
		throw new IllegalArgumentException("No hay negativo");
	}
	
	public static void main(String[] args) {
		try {
			primerNumeroNegativo("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
