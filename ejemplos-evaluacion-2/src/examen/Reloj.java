package examen;


public class Reloj {

	private static final int SEGUNDOSENUNDIA = 60*60*24;
	// SEGUNDOS DESDE LA MEDIA NOCHE
	private int _segundos;

	public int getSegundos() {
		return _segundos%60;
	}

	public int getMinutos() {
		return (_segundos/60)%60;
	}

	public int getHoras() {
		return _segundos/(60*60);
	}

	public Reloj() {
		this(0,0,0);
	}
	
	public Reloj( int hora, int minuto, int segundo ){
		comprueba(hora,0,23, "hora mal");
		comprueba(minuto,0,59, "minuto mal");
		comprueba(segundo,0,59, "segundo mal");
		_segundos = segundo + minuto*60 + hora*60*60;
	}

	
	private void comprueba(int valor, int min, int max, String mensaje ) {
		if(valor < min || valor > max ){
			throw new IllegalArgumentException(mensaje);
		}
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", getHoras(), getMinutos(), getSegundos() );
	}
	
	
	public void tick(){
		_segundos += 1;
		ajustaAlDia();
	}
	
	public void tick( int hora, int minuto, int segundo ){
		_segundos += segundo + minuto*60 + hora*60*60;
		ajustaAlDia();
	}

	private void ajustaAlDia() {
		_segundos %= SEGUNDOSENUNDIA;
		
	}
	
}
