import java.util.*;
/**
 * Write a description of class NumerosAlReves here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumerosAlReves
{
    public static void main( String args[] ){
        Scanner in = new Scanner(System.in);
        int[] numeros = new int[4];

        for( int i = 0 ; i < numeros.length ; i += 1 ){
            System.out.printf( "Dime el número %d:", (i+1) );
            int numeroLeido = Integer.parseInt( in.nextLine() );
            numeros[i] = numeroLeido;
        }

        System.out.println( "Al revés:" );
        for( int i = 0 ; i < numeros.length ; i += 1 ){
            System.out.printf( "%d\n", numeros[numeros.length-i-1] );
        }

        System.out.println( "Al revés:" );
        for( int i = numeros.length-1 ; i >= 0 ; i -= 1 ){
            System.out.printf( "%d\n", numeros[i] );
        }

    }
}
