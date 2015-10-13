import java.util.*;
/**
 * Write a description of class ElMasGrandeHastaCero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElMasGrandeHastaCero
{
    public static void main( String args[] ){
        Scanner scan = new Scanner(System.in);

        System.out.println( "_________________________________" );
        System.out.println( "Calcularé el máximo de los números, hasta que se introduzca un cero" );

        int maximo = Integer.MIN_VALUE;

        int dato = 0;
        int cuantos = 0;
        int suma = 0;
        do{
            cuantos = cuantos + 1;

            System.out.printf( "Dato %d:", cuantos);

            dato = Integer.parseInt(scan.nextLine());

            suma = suma + dato;

            if( dato > maximo ){
                maximo = dato;
            }
        }while( dato != 0 );

        cuantos = cuantos -1;

        System.out.printf( "El máximo de los %d datos es %d y la media es %.1f\n", cuantos, maximo, (float)suma/(float)cuantos );
        System.out.println( "La media es " + (float)suma/(float)cuantos );

    }

}
