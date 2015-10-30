
/**
 * Write a description of class Fibonacci here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fibonacci
{

    private static void traza(String s){
        System.err.println(s);
    }

    private static long fibonacci(long l){
        traza( "fibonnaci: " + l );
        if( l== 0) 
            return 0;
        else if( l == 1 ) 
            return 1;
        else {
            traza( "  para fibonnaci: " + l + " necesito los dos menores:" + (l-1) + "," +(l-2) );
            return fibonacci(l-1)+fibonacci(l-2);
        }
    }

    public static void main(String args[]){
        System.out.println( fibonacci(5) );
    }

}
