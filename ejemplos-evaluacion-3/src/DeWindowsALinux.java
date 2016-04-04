import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class DeWindowsALinux {

	public static void main(String[] args) throws IOException {
		if( args.length != 2 ){
			System.out.println("Uso: <fichero origen en ISO-8859-1> <destino en UTF-8>");
			System.exit(1);
		}
		
		String origen = args[0];
		String destino = args[1];
		
		Reader in = null;
		Writer out = null;
		try{
			in = new InputStreamReader( new FileInputStream(origen), "ISO-8859-1");
			out = new OutputStreamWriter( new FileOutputStream(destino), "UTF-8");
			
			int c = in.read();
			while( c != -1 ){
				out.write(c);
				c = in.read();
			}
		}
		finally{
			if( in != null ) in.close();
			if( out != null ) out.close();
		} 
	}
}
