import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopiarDirectorio {

	public static void main(String[] args) throws IOException {
		if( args.length != 2 ){
			System.out.println("<origen> <destino>");
			System.exit(-1);
		}
		
		String src = args[0];
		String dst = args[1];
		
		File fDst = new File(dst);
		if( fDst.exists() ){
			System.out.println("El destino ya existe");
			System.exit(-2);
		}
		
		copiarFicheroODirectorio( new File(src), fDst );
	}

	private static void copiarFicheroODirectorio(File src, File dst) throws IOException {
		
		System.out.println(src + " --> " + dst);
		
		// PROGRAMACION DEFENSIVA
		if(dst.exists()){
			throw new IllegalStateException();
		}
		
		if( src.isFile() ){
			copiarFichero(src,dst);
		}
		else{
			copiarDirectorio(src,dst);
		}
		
	}

	private static void copiarDirectorio(File src, File dst) throws IOException {
		dst.mkdirs();
		for( File f: src.listFiles() ){
			File nuevo = new File(dst,f.getName());
			copiarFicheroODirectorio( f, nuevo );
		}
	}

	private static void copiarFichero(File src, File dst) throws IOException {
		try(InputStream in = new FileInputStream(src) ;
		OutputStream out = new FileOutputStream(dst) ){
			copiarStreams(in,out);
		}
	}

	private static void copiarStreams(InputStream in, OutputStream out) throws IOException {
		byte buffer[] = new byte[8192];
		int leido = in.read(buffer);
		while (leido != -1) {
			out.write(buffer,0,leido);
			leido = in.read(buffer);
		}		
	}
}
