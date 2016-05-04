package contactos.swing;

import java.util.Arrays;

public class Contacto {
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String nombre = "<sin nombre>";
	private String apellidos = "<sin apellidos>";
	private byte[] imagen;
	
	// HAY QUE CAMBIAR ESTO PARA QUE SEA UN NUMERO VARIABLE
	// DE MOMENTO, HACEMOS CUATRO EMAILS
	private DatoAdicional[] adicionales = new DatoAdicional[]{
			new DatoAdicional(),
			new DatoAdicional(),
			new DatoAdicional(),
			new DatoAdicional()
	};
	
	public class DatoAdicional{
		private String valor = "<sin valor>";
		private String ambito = "Personal"; // PROFESIONAL, PERSONAL
		private String tipo = "email"; // EMAIL, TELEFONO, FAX
		public String getValor() {
			return valor;
		}
		public void setValor(String valor) {
			this.valor = valor;
		}
		public String getAmbito() {
			return ambito;
		}
		public void setAmbito(String ambito) {
			this.ambito = ambito;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public DatoAdicional[] getAdicionales() {
		return adicionales;
	}

	public void setAdicionales(DatoAdicional[] adicionales) {
		this.adicionales = adicionales;
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", imagen=" + Arrays.toString(imagen) + "]";
	}
	
	
	
	
	
}
