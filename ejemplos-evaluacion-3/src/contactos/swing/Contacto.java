package contactos.swing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import contactos.jdbc.DatoDeContacto;

@Entity
public class Contacto {
	
	
	public Contacto(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
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

	@Column
	private String nombre = "<sin nombre>";
	
	@Column
	private String apellidos = "<sin apellidos>";
	
	@Column
	private byte[] imagen;
	
	@OneToMany(mappedBy="contacto")
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
