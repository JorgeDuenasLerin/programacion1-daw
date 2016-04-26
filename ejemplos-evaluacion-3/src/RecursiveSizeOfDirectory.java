import java.io.File;

public class RecursiveSizeOfDirectory {
	public static void main(String[] args) {
		if( args.length != 1 ){
			System.out.println("<directorio o fichero>");
			System.exit(-1);
		}
		
		File f = new File( args[0]);
		long size = sizeOf(f);
		System.out.printf("El tamaño de %s es %d\n", f, size );
	}

	private static long sizeOf(File f) {
		if( f.isFile() ){
			return f.length();
		}
		else if( f.listFiles() != null ){
			long ret = 0;
			for( File child: f.listFiles() ){
				ret += sizeOf(child);
			}
			return ret;
		}
		else{
			return 0;
		}
	}
}
