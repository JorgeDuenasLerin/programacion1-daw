package examen;

import java.util.Scanner;
import static java.lang.Math.*;

public class EstadisticaDeLetras{
    public static void main( String args[] ){
        Scanner in = new Scanner(System.in);
        
        System.out.println( "Linea de texto?" );
        String linea = in.nextLine();
 
        char letra = letraMasRepetida(linea);
        System.out.printf( "Letra más repetida: %c\n", letra );
    }

	private static char letraMasRepetida(String linea) {
		int maximas = Integer.MIN_VALUE;
		char letra = 0;
		for( char l = 'a' ; l <= 'z' ; l++ ){
			int cuantas = cuantasLetras( linea, l );
			if( cuantas > maximas ){
				maximas = cuantas;
				letra = l;
			}
		}
		
		return letra;
	}

	private static int cuantasLetras(String linea, char l) {
		int contador = 0;
		for( char c : linea.toLowerCase().toCharArray() ){
			if( c == l ){
				contador += 1;
			}
		}
		return contador;
	}
}