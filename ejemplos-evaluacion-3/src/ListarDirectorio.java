import java.io.File;
import java.io.IOException;

public class ListarDirectorio {
	public static void main(String[] args) throws IOException {
		if( args.length != 1 ){
			System.err.println("Hace falta un parámetro que sea un directorio");
			System.exit(1);
		}
		File dir = new File(args[0]);
		if( !dir.exists() ){
			System.err.println("Hace falta un parámetro que sea un directorio");
			System.exit(1);
		}
		
		listar(dir, "");
	}

	private static void listar(File dir, String indentacion ) throws IOException {
		System.out.println(indentacion + dir.getCanonicalPath() );
		if( dir.isDirectory() ){
			for( File f: dir.listFiles() ){
				listar(f, indentacion + "  ");
			}
		}
	}
}
