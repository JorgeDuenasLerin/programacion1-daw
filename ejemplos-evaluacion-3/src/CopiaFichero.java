import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopiaFichero {

	public static void main(String args[]) throws IOException {
		if (args.length != 2) {
			System.out.println("Uso: <fichero origen> <fichero destino>");
			System.exit(0);
		}

		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(args[0]);
			out = new FileOutputStream(args[1]);
			int leido = in.read();
			while (leido != -1) {
				out.write(leido);
				leido = in.read();
			}
			System.out.println("Fichero copiado");
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

}
