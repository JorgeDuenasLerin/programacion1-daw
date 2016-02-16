package animales;

public class MainDeAnimales {

	private static void comparar(Animal a1, Animal a2){
		System.out.println("---------------------------");
		System.out.println(a1);
		System.out.println(a2);
		System.out.println("== " + (a1==a2));
		System.out.println("equals " + (a1.equals(a2)));
	}
	
	public static void main(String[] args) {
		Animal a1 = new Pelicano("Cano");
		Animal a2 = new Pinguino("Quino");
		Animal a3 = new Lobo("Bobo");
		Animal a4 = new Lobo("Bobo Bo");


		comparar(a1,a1);
		comparar(a1,a2);
		comparar(a2,a3);
		comparar(a3,a4);
	}
}
