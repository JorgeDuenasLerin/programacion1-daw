import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

public class HashmapDeserializado {

	public static <K, V> void escribeMapaAFichero(HashMap<K, V> map, String fichero) throws IOException {
		FileOutputStream out = null;
		ObjectOutputStream oout = null;
		try {
			out = new FileOutputStream(fichero);
			oout = new ObjectOutputStream(out);
			oout.writeObject(map);
			
			
			oout.writeObject( "Hola");
		} finally {
			if (out != null)
				out.close();
			if (oout != null)
				oout.close();
		}
	}

	public static void main(String[] args) throws IOException {
		HashMap<String, String> m = new HashMap<String, String>();

		m.put("a", "A");
		m.put("Álvaro", "González");
		escribeMapaAFichero(m, "mapa.ser");
	}
}
