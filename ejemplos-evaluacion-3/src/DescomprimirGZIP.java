import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

public class DescomprimirGZIP {

	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		OutputStream out = System.out;
		InputStream zin = null;
		
		try{
			zin = new GZIPInputStream(in);
			
			byte buffer[] = new byte[1<<16]; 
			
			int leidos = zin.read(buffer);
			while( leidos != -1 ){
				out.write(buffer,0,leidos);
				leidos = zin.read(buffer);
			}
		}
		finally{
			if( zin != null ) zin.close();
		}
		
	}
	
}
