package contactos.swing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import contactos.jdbc.DatoDeContacto;

public class Contacto {
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		for( DatoDeContacto dc: getDatosDeContacto() ){
			dc.setIdContacto(id);
		}
	}

	private String nombre = "<sin nombre>";
	private String apellidos = "<sin apellidos>";
	private byte[] imagen;
	
	
	private List<DatoDeContacto> datos;
	
	private List<DatoDeContacto> getDatos(){
		if (datos == null) {
			datos = new ArrayList<>();
		}
		return datos;
	}
	
	public void addDato( DatoDeContacto dc ){
		dc.setIdContacto(getId());
		getDatos().add(dc);
	}
	
	public void removeDato( DatoDeContacto dc ){
		getDatos().remove(dc);
	}
	
	public List<DatoDeContacto> getDatosDeContacto(){
		return Collections.unmodifiableList(getDatos());
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

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + getDatosDeContacto() + "]";
	}
	
	
	
	
	
}
