
public class Flush {


	public static void main(String[] args) throws InterruptedException {
		String msg = "El mensaje";
		
		for( byte b : msg.getBytes() ){
			espera();
			System.out.write(b);
		}
		System.out.flush();

	}

	private static void espera() throws InterruptedException {
		Thread.sleep(1000);
		
	}
}
