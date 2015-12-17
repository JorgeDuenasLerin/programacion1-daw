import java.util.Scanner;





public class EstoQueNumeroEs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Escribe un número:");
		String s = in.nextLine();
		System.out.printf("%s es un número entero decimal: %s\n", s, esEnteroDecimal(s,10) );
		System.out.printf("%s es un número entero hexadecimal: %s\n", s, esEnteroDecimal(s,16) );
		System.out.printf("%s es un número real decimal: %s\n", s, esRealDecimal(s) );
	}

	private static boolean esRealDecimal(String s) {
		try{
			Double.parseDouble(s);
			return true;
		}
		catch(  NumberFormatException e ){
			return false;
		}
	}

	private static boolean esEnteroDecimal(String s, int base) {
		try{
			Integer.parseInt(s,base);
			return true;
		}
		catch(  NumberFormatException e ){
			return false;
		}
			
	}
}
