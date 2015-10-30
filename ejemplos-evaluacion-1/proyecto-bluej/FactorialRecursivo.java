
/**
 * Write a description of class FactorialRecursivo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FactorialRecursivo
{

    public static long factorialRecursivo(long n){
        if( n == 0 ) {
            return 1;
        }
        else {
            long masSimple = factorialRecursivo(n-1);
            System.out.println( "masSimple:" + masSimple );
            return n * masSimple;
        }
    }
    
    public static void main(String args[]){
        long f = factorialRecursivo(6);
    }

    
}
