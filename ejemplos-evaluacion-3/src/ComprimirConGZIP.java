import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class ComprimirConGZIP {

	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		OutputStream out = System.out;
		OutputStream zout = null;
		
		try{
			zout = new GZIPOutputStream(out);
			
			byte buffer[] = new byte[1<<16]; 
			
			int leidos = in.read(buffer);
			while( leidos != -1 ){
				zout.write(buffer,0,leidos);
				leidos = in.read(buffer);
			}
		}
		finally{
			if( zout != null ) zout.close();
		}
		
	}
	
}
