package animales;

public abstract class Animal {
	private String nombre;

	public Animal(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public final String getEspecie(){
		String n = getClass().getName();
		return n.substring(n.lastIndexOf('.')+1);
	}
	
	

	public abstract boolean vuela();

	public abstract boolean sangreCaliente();

	public abstract boolean oviparo();

	public final boolean sangreFria() {
		return !sangreCaliente();
	}

	public final boolean viviparo() {
		return !oviparo();
	}

	@Override
	public String toString() {
		return String.format(" %s : especie: %s  vuela: %b , caliente: %b , oviparo: %b ",
				getNombre(), getEspecie(), vuela(), sangreCaliente(), oviparo());
	}

	@Override
	public boolean equals(Object o) {
		if(this == o){
			return true;
		}
		if( !(o instanceof Animal) ){
			return false;
		}
		
		Animal otroAnimal = (Animal) o;
		String miEspecie = getEspecie();
		String otraEspecie = otroAnimal.getEspecie();
		String miNombre = getNombre();
		String otroNombre = otroAnimal.getNombre();
		
		return miEspecie.equals(otraEspecie) && miNombre.equals(otroNombre);
	
	}
	
}
