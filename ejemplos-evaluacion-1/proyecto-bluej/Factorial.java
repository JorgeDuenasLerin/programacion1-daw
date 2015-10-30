import java.util.*;

/**
 * Write a description of class Factorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Factorial
{
    private static long factorial(long n){
        long ret = 1;

        for( int c = 1 ; c <= n ; c += 1 ){
            ret *= c;
        }

        return ret;
    }

    private static long combinatorio(long a, long b){
        return factorial(a)/(factorial(b)*factorial(a-b));
    }

    private static long preguntaNumero(Scanner in, String mensaje){
        long ret = 0;

        System.out.print( mensaje );
        try{
            String line = in.nextLine();
            if( line.trim().equals("exit") ){
                System.exit(0);
            }
            ret = Long.parseLong( line );

        }catch( Exception e ){
            System.out.println( "eso no es un número" );
            return preguntaNumero(in,mensaje);
        }

        return ret;
    }

    public static void mainConMetodos(String[] args){
        Scanner in = new Scanner(System.in);
        long a = preguntaNumero( in,"Diga a:" );
        long b = preguntaNumero( in,"Diga b:" );
        System.out.printf( "%d sobre %d es: %d\n", a, b, combinatorio(a,b) );
    }

    public static void main(String[] args){
        //mainSinMetodos(args);
        mainConMetodos(args);
    }

    public static void mainSinMetodos( String[] args ){
        Scanner in = new Scanner(System.in);
        System.out.println( "Diga a:" );

        long a = Long.parseLong( in.nextLine() );
        System.out.println( "Diga b:" );

        long b = Long.parseLong( in.nextLine() );

        long factorialA = 1;
        for( long c = 1 ; c <= a ; c += 1 ){
            factorialA *= c;
        }

        long factorialB = 1;
        for( long c = 1 ; c <= b ; c += 1 ){
            factorialB *= c;
        }

        long factorialAmenosB = 1;
        for( long c = 1 ; c <= (a-b) ; c += 1 ){
            factorialAmenosB *= c;
        }

        long asobreb = factorialA/(factorialB * factorialAmenosB);

        System.out.printf( "%d sobre %d es: %d\n", a, b, asobreb );

    }
}
