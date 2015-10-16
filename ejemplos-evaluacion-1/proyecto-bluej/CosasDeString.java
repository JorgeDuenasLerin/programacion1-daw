
/**
 * Write a description of class CosasDeString here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CosasDeString
{
    public static void main(String args[]){
        String s = "Un nombre y un apellido y un nombre      ";
        System.out.println("______________________________");
        System.out.println( s.toLowerCase() );
        System.out.println( s.toUpperCase().toLowerCase() );
        System.out.println( s.length() );
        System.out.println( s.charAt(5) );
        System.out.println( s.replaceAll("n","NN" ) );
        System.out.println( s.indexOf("ombre", 31) );
        System.out.println( s.trim() );
        System.out.println( s.trim().length() );
        
        System.out.println( s.substring(3,5) );
        
    }
}
