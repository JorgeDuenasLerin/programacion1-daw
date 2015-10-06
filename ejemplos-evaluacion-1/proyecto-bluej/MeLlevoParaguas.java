import java.util.*;

/**
 * Write a description of class MeLlevoParaguas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MeLlevoParaguas
{
    public static void main( String args[] ){
        
        Scanner in = new Scanner(System.in);

        System.out.println( "___________________________" );

        // DATOS
        System.out.print( "Dime si llueve hoy:" );
        
        boolean llueveHoy = Boolean.parseBoolean(in.nextLine());
        boolean llovioAyer = false;
        boolean llovioAnteayer = true;

        // CUENTAS CON LOS DATOS, ESTO NO CAMBIA CUANDO CAMBIEN LOS DATOS
        // usando !, &&, ||, (, )
        boolean chubasquero = llovioAyer && llovioAnteayer;
        boolean paraguas = (llueveHoy || llovioAyer) && !chubasquero;

        // MIRO LO QUE SALE
        System.out.println( "hoy:" + llueveHoy + "  ayer:" + llovioAyer + "  anteayer:" + llovioAnteayer );
        System.out.println( "paraguas:" + paraguas );
        System.out.println( "chubasquero:" + chubasquero );
    }
}
