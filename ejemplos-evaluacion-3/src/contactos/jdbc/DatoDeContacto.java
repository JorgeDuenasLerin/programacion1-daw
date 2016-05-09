package contactos.jdbc;

public class DatoDeContacto {

	private int idContacto;
	private String tipo;
	private String ambito;
	private String valor;

	public DatoDeContacto(String tipo, String ambito, String valor) {
		this(0,tipo,ambito,valor);
	}

	
	public DatoDeContacto(int idContacto, String tipo, String ambito, String valor) {
		this.idContacto = idContacto;
		this.tipo = tipo;
		this.ambito = ambito;
		this.valor = valor;
	}

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "DatoDeContacto [" + idContacto + ": tipo=" + tipo + ", ambito=" + ambito + ", valor=" + valor + "]";
	}
	
	
	
	
	
}
