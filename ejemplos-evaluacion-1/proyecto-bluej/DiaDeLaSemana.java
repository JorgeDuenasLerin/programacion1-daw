import java.util.*;
/**
 * Write a description of class DiaDeLaSemana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiaDeLaSemana
{
    public static void main( String args[] ){
        Scanner in = new Scanner(System.in);

        System.out.println( "____________________\nempiezo otra vez, no te confundas con lo de antes" );

        System.out.print( "Número del día de la semana:" );
        int dia = Integer.parseInt( in.nextLine() );

        String nombreDia = "sin inicializar";
        switch( dia ){
            case 1: nombreDia = "lunes"; break;
            case 2: nombreDia = "martes"; break;
            case 3: nombreDia = "miércoles"; break;
            case 4: nombreDia = "jueves"; break;
            case 5: nombreDia = "viernes"; break;
            case 6: nombreDia = "sábado"; break;
            case 7: nombreDia = "domingo"; break;
            default: nombreDia = "ese día no existe en una semana normal" ;
        }
        System.out.printf( "El día asociado a %d es %s\n", dia, nombreDia );

        System.out.print( "Cuántos días van a pasar?:" );
        int diasAdicionales = Integer.parseInt( in.nextLine() );

        switch( ((dia-1)+diasAdicionales)%7 + 1){
            case 1: nombreDia = "lunes"; break;
            case 2: nombreDia = "martes"; break;
            case 3: nombreDia = "miércoles"; break;
            case 4: nombreDia = "jueves"; break;
            case 5: nombreDia = "viernes"; break;
            case 6: nombreDia = "sábado"; break;
            case 7: nombreDia = "domingo"; break;
            default: nombreDia = "ese día no existe en una semana normal" ;
        }

        System.out.printf( "El día asociado a %d más %d días es %s\n", dia, diasAdicionales, nombreDia );
    }
}
