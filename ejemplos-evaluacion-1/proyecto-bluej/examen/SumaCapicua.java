package examen;

import java.util.Scanner;

public class SumaCapicua {

	public static void main(String[] args) {
		pruebaCapicua();
		Scanner in = new Scanner(System.in);
		int n1 = preguntaNumero(in, "Primer número?");
		int n2 = preguntaNumero(in, "Segundo número?");
		int suma = n1 + n2;
		System.out.printf("la suma de %d y %d es %d\n", n1, n2, suma);
		if (esCapicua(suma)) {
			System.out.printf("%d si es capicua\n", suma);
		} else {
			System.out.printf("%d no es capicua\n", suma);
		}
	}
	
	private static void pruebaCapicua(){
		for( int i = 0 ; i < 1000000 ; i++ ){
			esCapicua(i);
		}
	}

	
	private static boolean esCapicua(int n) {
		boolean b1 = esCapicua1(n);
		boolean b2 = esCapicua2(n);
		boolean b3 = esCapicua3(n);
		
		if( b1 != b2 || b2 != b3 ){
			throw new IllegalStateException();
		}
		
		return b1;
	}
	
	private static boolean esCapicua1(int n) {
		String s = Integer.toString(n);
		int principio = 0;
		int fin = s.length() - 1;
		while (principio <= fin) {
			if (s.charAt(principio) != s.charAt(fin)) {
				return false;
			}

			principio += 1;
			fin -= 1;
		}
		return true;
	}
	
	private static boolean esCapicua3(int n){
		String alDerecho = String.valueOf(n);
		String alReves = new StringBuilder(alDerecho).reverse().toString();
		return alDerecho.equals(alReves);
	}

	private static boolean esCapicua2(int n) {
		String s = Integer.toString(n);
		for (int i = 0; i < s.length()/2; i += 1) {
			int fin = s.length() - i - 1;

			if (s.charAt(i) != s.charAt(fin)) {
				return false;
			}
		}
		return true;
	}

	private static int preguntaNumero(Scanner in, String msg) {
		while (true) {
			System.out.println(msg);
			try {
				int n = Integer.parseInt(in.nextLine());
				return n;
			} catch (NumberFormatException e) {
				System.out.println("Eso no es un número");
			}
		}
	}

}
