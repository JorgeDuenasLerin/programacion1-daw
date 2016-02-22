import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;



public class Contarduplicados {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String,Integer> mapa = new HashMap<String,Integer>();
		String linea = in.nextLine();
		while( !linea.equals("fin") ){
			
			Integer veces = mapa.get(linea);
			if( veces == null ){
				mapa.put(linea, 1);
			}
			else{
				mapa.put(linea,veces+1);
			}

			linea = in.nextLine();
		}

		System.out.println("*******************Sin ordenar");
		for( String s: mapa.keySet() ){
			System.out.printf( "%s -> %d veces\n", s, mapa.get(s));
		}
		
		System.out.println("*******************Ordenado por palabra");
		for( String s: conjuntoOrdenado(mapa.keySet()) ){
			System.out.printf( "%s -> %d veces\n", s, mapa.get(s));
		}

		System.out.println("*******************Ordenado por veces");
		for( String s: clavesOrdenadasPorVeces(mapa) ){
			System.out.printf( "%s -> %d veces\n", s, mapa.get(s));
		}

	}

	private static SortedSet<String> clavesOrdenadasPorVeces(Map<String,Integer> mapa) {
		Set<String> claves = mapa.keySet();
		Comparator<String> comparadorPorRepeticiones = new Comparator<String>() {

			@Override
			public int compare(String palabra1, String palabra2) {
				Integer repeticionesPalabra1 = mapa.get(palabra1);
				Integer repeticionesPalabra2 = mapa.get(palabra2);
				
				int comparacionDeRepeticiones = repeticionesPalabra1.compareTo(repeticionesPalabra2);
				if( comparacionDeRepeticiones != 0 ){
					return comparacionDeRepeticiones;
				}
				return palabra1.compareTo(palabra2);
			}
			
		};
		SortedSet<String> ret = new TreeSet<String>(comparadorPorRepeticiones);
		ret.addAll(claves);
		return ret;
		
	}

	private static SortedSet<String> conjuntoOrdenado(Set<String> keySet) {
		SortedSet<String> ret = new TreeSet<String>();
		ret.addAll(keySet);
		return ret;
	}
}
