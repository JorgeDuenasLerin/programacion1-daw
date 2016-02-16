package animales;

public abstract class Mamifero extends Animal {

	public Mamifero(String nombre) {
		super(nombre);
	}


	@Override
	public boolean vuela() {
		return false;
	}

	@Override
	public final boolean sangreCaliente() {
		return true;
	}

	@Override
	public boolean oviparo() {
		return false;
	}

}
