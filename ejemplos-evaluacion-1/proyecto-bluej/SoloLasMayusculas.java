import java.util.Scanner;

public class SoloLasMayusculas {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Dime una línea:");
		String linea = in.nextLine();
		
		String[] palabrasDeFrase = linea.split(" ");
		
		for (String palabra: palabrasDeFrase) {
			if( tieneMayuscula(palabra) ){
				System.out.print(palabra + " ");
			}
			
		}
	}

	private static boolean tieneMayuscula(String palabra) {
		char[] letras = palabra.toCharArray();
		for (char c: letras) {
			if( caracterEsMayuscula(c) ){
				return true;
			}
		}
		return false;
	}

	private static boolean caracterEsMayuscula(char c) {
		return Character.isUpperCase(c);
	}

}
