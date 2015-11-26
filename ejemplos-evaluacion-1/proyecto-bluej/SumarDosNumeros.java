import java.util.Scanner;

public class SumarDosNumeros {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = preguntaNumero(in, 1);
		int n2 = preguntaNumero(in, 2);
		System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
	}

	private static int preguntaNumero(Scanner in, int i) {
		while (true) {
			System.out.printf("Introduce el número %d:", i);
			try {
				int n = Integer.parseInt(in.nextLine());
				return n;
			} catch (NumberFormatException e) {
				System.out.println("Eso no es un número");
			}
		}
	}

}
