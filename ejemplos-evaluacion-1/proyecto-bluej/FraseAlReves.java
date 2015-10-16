import java.util.*;
/**
 * Write a description of class FraseAlReves here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FraseAlReves
{
    public static void main(String args[] ){
        Scanner in = new Scanner(System.in);

        System.out.print( "Dime una frase:" );
        String frase = in.nextLine();

        String palabras[] = frase.split(" ");
        for( int i = palabras.length-1; i >= 0 ; i -= 1 ){
            String p = palabras[i];
            System.out.print( p );
            System.out.print( " " );
        }
    }
}
