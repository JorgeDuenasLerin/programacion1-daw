import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class HashmapSerializado {

	@SuppressWarnings("unchecked")
	public static <K, V> HashMap<K,V> leerMapaDeFichero(String fichero) throws IOException, ClassNotFoundException {
		FileInputStream in = null;
		ObjectInputStream oin = null;
		try {
			in = new FileInputStream(fichero);
			oin = new ObjectInputStream(in);
			return (HashMap<K, V>) oin.readObject();
			
		} finally {
			if (in != null)
				in.close();
			if (oin != null)
				oin.close();
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		HashMap<String, String> m = leerMapaDeFichero("/etc/passwd");
		System.out.println(m);
	}
}
