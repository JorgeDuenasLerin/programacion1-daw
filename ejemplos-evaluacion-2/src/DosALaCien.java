import java.math.BigInteger;

public class DosALaCien {

	public static void main(String[] args) {
		BigInteger bi = new BigInteger("1");
		BigInteger _2 = new BigInteger("2");
		
		for (int i = 0; i < 101; i++) {
			System.out.println(bi);
			bi = bi.multiply(_2);
		}
	}
	
}
