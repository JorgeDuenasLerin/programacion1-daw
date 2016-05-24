package contactos.swing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import contactos.jdbc.DatoDeContacto;
import contactos.jdbc.Importancia;

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
	
	
	@ManyToOne
	@JoinColumn(name="idImportancia")
	public Importancia importancia;
	
	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

	private List<DatoDeContacto> getDatos(){
		if (datos == null) {
			datos = new ArrayList<>();
		}
		return datos;
	}
	
	public void addDato( DatoDeContacto dc ){
		dc.setIdContacto(getId());
		dc.contacto = this;
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
