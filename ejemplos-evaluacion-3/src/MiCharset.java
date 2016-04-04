import java.nio.charset.Charset;


public class MiCharset {

	public static void main(String[] args) {
		System.out.printf("El charset por defecto es: %s\n", Charset.defaultCharset());
		for( String s: Charset.availableCharsets().keySet() ){
			System.out.println(s);
		}
	}	
		
	

}
