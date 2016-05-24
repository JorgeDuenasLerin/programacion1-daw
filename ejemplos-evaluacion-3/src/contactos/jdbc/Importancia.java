package contactos.jdbc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Importancia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int idImportancia;
	
	@Column
	private String descripcion;

	public int getIdImportancia() {
		return idImportancia;
	}

	public void setIdImportancia(int idImportancia) {
		this.idImportancia = idImportancia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
