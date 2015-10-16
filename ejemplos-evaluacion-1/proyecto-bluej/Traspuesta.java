import java.util.*;
/**
 * Write a description of class Traspuesta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Traspuesta
{

    public static void main( String args[] ){
        System.out.println( "___________________________________" );
        Scanner in = new Scanner(System.in);

        // PRIMERA DIMENSION: FILAS
        // SEGUNDA DIMENSIO: COLUMNAS
        int[][] m = new int[3][4];

        System.out.printf( "Mete una matriz de %dx%d:\n", m.length, m[0].length );
        
        for( int f = 0 ; f < m.length ;f += 1 ){
        
            String line = in.nextLine();
            String numeros[] = line.split("\\s");
            if( numeros.length != m[f].length ){
                System.err.println( "Algo va mal" );
            }
            
            for( int c = 0 ; c < m[f].length ; c += 1 ){
                int numero = Integer.parseInt( numeros[c] );
                m[f][c] = numero;
            }
        }

        System.out.println( "NORMAL ___________________________________" );
        for( int f = 0 ; f < m.length ;f += 1 ){
            for( int c = 0 ; c < m[f].length ; c += 1 ){
                System.out.printf( "%d\t", m[f][c] );
            }
            System.out.println( );
        }

        System.out.println( "TRANSPUESTA ___________________________________" );
        for( int c = 0 ; c < m[0].length ; c += 1 ){
            for( int f = 0 ; f < m.length ;f += 1 ){
                System.out.printf( "%d\t", m[f][c] );
            }
            System.out.println( );
        }

    }
}
