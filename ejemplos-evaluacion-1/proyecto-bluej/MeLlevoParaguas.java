
/**
 * Write a description of class MeLlevoParaguas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MeLlevoParaguas
{
    public static void main( String args[] ){

        // DATOS, LOS CAMBIO PARA PROBAR CASOS
        boolean llueveHoy = true;
        boolean llovioAyer = false;
        boolean llovioAnteayer = true;

        // CUENTAS CON LOS DATOS, ESTO NO CAMBIA CUANDO CAMBIEN LOS DATOS
        // usando !, &&, ||, (, )
        boolean chubasquero = llovioAyer && llovioAnteayer;
        boolean paraguas = (llueveHoy || llovioAyer) && !chubasquero;

        // MIRO LO QUE SALE
        System.out.println( "___________________________" );
        System.out.println( "hoy:" + llueveHoy + "  ayer:" + llovioAyer + "  anteayer:" + llovioAnteayer );
        System.out.println( "paraguas:" + paraguas );
        System.out.println( "chubasquero:" + chubasquero );
    }
}
