import java.util.Scanner;


/**
 * Write a description of class EjemploDeScanner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EjemploDeScanner
{
    public static void main( String args[] ) {
        Scanner in = new Scanner(System.in);
        
        System.out.print( "¿Cómo te llamas?: " );
        String nombre = in.nextLine();
        System.out.println( "Hola " + nombre + ", encantado de conocerte" );
        System.out.print( "¿Cuántos años tienes?: " );
        String age = in.nextLine();
        int ageEntero = Integer.parseInt(age);
        System.out.println( "¡Tendrás 100 años dentro de " + (100 -ageEntero) + " años!" );
        
    }
}
