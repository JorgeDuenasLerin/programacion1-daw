package animales;

public class Murcielago extends Mamifero{

	public Murcielago(String nombre) {
		super(nombre);
	}

	
	@Override
	public boolean vuela() {
		return true;
	}


}
