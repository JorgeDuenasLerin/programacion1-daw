
/**
 * Write a description of class Ortografia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ortografia
{
    public static void main(String[] args){
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println( "Una frase con acentos:" );
        String frase = in.nextLine();

        frase = frase.replaceAll("á", "a" );
        frase = frase.replaceAll("Á", "A" );

        frase = frase.replaceAll("é", "e" );
        frase = frase.replaceAll("É", "E" );
        
        frase = frase.replaceAll("í", "i" );
        frase = frase.replaceAll("Í", "I" );
        
        frase = frase.replaceAll("ó", "o" );
        frase = frase.replaceAll("Ó", "O" );
        
        frase = frase.replaceAll("ú", "u" );
        frase = frase.replaceAll("Ú", "U" );

        System.out.println( frase) ;

    }
}
