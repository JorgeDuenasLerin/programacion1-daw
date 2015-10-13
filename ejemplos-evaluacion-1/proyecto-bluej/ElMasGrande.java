import java.util.*;

/**
 * Write a description of class ElMasGrande here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElMasGrande
{
    public static void main( String args[] ){
        Scanner scan = new Scanner(System.in);

        System.out.println( "_________________________________" );
        System.out.print( "Cuántos números tengo que comparar:" );
        int total = Integer.parseInt(scan.nextLine());
        int maximo = Integer.MIN_VALUE;

        for( int c = 1 ; c <= total ; c = c + 1 ){
            System.out.printf( "Dato %d/%d:", c, total );
            
            int dato = Integer.parseInt(scan.nextLine());
            if( dato > maximo ){
                maximo = dato;
            }

        }

        System.out.printf( "El máximo de los datos es %d\n", maximo );

    }
}
