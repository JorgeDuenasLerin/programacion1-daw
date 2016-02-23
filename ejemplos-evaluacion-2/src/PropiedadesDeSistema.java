import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

public class PropiedadesDeSistema {

	public static void main(String[] args) throws IOException {
		Properties p = System.getProperties();
		p.store(System.out, "Mis propiedades");
	}
}
