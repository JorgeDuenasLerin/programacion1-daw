package animales;

class Pinguino extends Ave {
	public Pinguino(String nombre) {
		super(nombre);
	}

	@Override
	public boolean vuela() {
		return false;
	}

	public String colorDePlumas() {
		return " negro y blanco ";
	}
}
