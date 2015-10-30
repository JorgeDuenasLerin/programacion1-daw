
/**
 * Write a description of class NombreAlReves here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NombreAlReves
{
    public static void main( String args[] ){

        new String("").valueOf("hola");
        String.valueOf("hola");
        
        "".length();
        String.length();
        
        
        if( args.length < 1 ){
            System.out.println( "Uso: <nombre al que dar la vuelta>" );
            System.exit(0);
        }
        String nombre = args[0];

        System.out.println( "El nombre es inicial es:" + nombre );

        System.out.print( "El nombre al revés es:" );
        for( int i = 0 ; i < nombre.length() ; i += 1 ){
            System.out.print( nombre.charAt(nombre.length() - i - 1) );
        }
        System.out.println( );
    }
}
