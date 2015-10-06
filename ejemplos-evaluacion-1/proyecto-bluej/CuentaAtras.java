
/**
 * Write a description of class CuentaAtras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CuentaAtras
{
    public static void main( String args[] ){
        System.out.println( "Cuenta atrás" );
        int total = 10;
        while( total > 0 ){
            if( total < 10 ){
                System.out.print( "..." );
            }
            System.out.println( total );
            total = total - 1;
        }
        System.out.println( "Ignición" );
    }
}
