import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MedicionIngenuaDeFichero {

	public static void main(String args[]) throws IOException {
		if (args.length == 0) {
			System.out.println("Se necesita un parametro que sea el nombre de fichero");
			System.exit(0);
		}

		InputStream in = null;
		try {
			in = new FileInputStream(args[0]);
			//in = new URL("http://192.168.1.19:8080/webcat/WebObjects/Web-CAT.woa").openStream();
			long contador = 0;
			long lineas = 1;
			System.out.printf( "linea %03d: ", lineas );
			int leido = in.read();
			while (leido != -1) {
				contador += 1;
				System.out.write(leido);
				if( leido == '\n' ){
					lineas += 1;
					System.out.printf( "linea %03d: ", lineas );
				}
				leido = in.read();
			}
			System.out.printf("El fichero mide %d bytes y tiene %d líneas\n", contador, lineas );
		} finally {
			// ESTE BLOQUE SE EJECUTA EN CUALQUIER CASO
			// HAYA O NO EXCEPCIONES EN EL BLOQUE try
			if (in != null) {
				in.close();
			}
		}
	}
}
