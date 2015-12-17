package examen;

import java.util.Scanner;
import static java.lang.Math.*;

public class EstadisticaDeTexto{
    public static void main( String args[] ){
        Scanner in = new Scanner(System.in);
        
        System.out.println( "Linea de texto?" );
        String linea = in.nextLine();
        
        if( !esCadenaVacia(linea) ){
        	int numero = numeroDePalabras(linea);
			System.out.printf( "Número de palabras: %d\n", numero );
			int larga = longitudPalabraMasLarga(linea);
			System.out.printf( "Longitud de la palabra más larga: %d\n", larga );
			int corta = longitudPalabraMasCorta(linea);
			System.out.printf( "Longitud de la palabra más corta: %d\n", corta );
        	
        }
        else{
        	
        	System.out.println( "Número de palabras: 0" );
        	System.out.println( "Longitud de la palabra más larga: No hay palabra más larga" );
        	System.out.println( "Longitud de la palabra más corta: No hay palabra más corta" );
        }
    }

	private static int numeroDePalabras(String linea) {
		return linea.split(" ").length;
	}

	private static int longitudPalabraMasLarga(String linea) {
		int ret = Integer.MIN_VALUE;
		for( String palabra: linea.split(" ") ){
			ret = max( ret, palabra.length() );
		}
		return ret;
	}

	private static int longitudPalabraMasCorta(String linea) {
		int ret = Integer.MAX_VALUE;
		for( String palabra: linea.split(" ") ){
			ret = min( ret, palabra.length() );
		}
		return ret;
	}

	private static boolean esCadenaVacia(String linea) {
		//return linea.trim().equals( "" ); 
		return linea.trim().length() == 0;
	}    
}