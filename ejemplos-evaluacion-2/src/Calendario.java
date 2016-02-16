
public class Calendario {

	private int dia;
	private int mes;
	private int año;
	
	public Calendario(){
		this(1,1,2016);
	}
	
	public Calendario(int dia, int mes, int año){
		this.dia = dia;
		this.mes = mes;
		this.año = año;
	}
	
	public void avanzaDia(){
		dia += 1;
		if( dia > diasDeMes(mes,año) ){
			dia = 1;
			mes +=1;
		}
		if( mes > 12 ){
			mes = 1;
			año += 1;
		}
	}
	
	public void avanzaSemana(){
		for( int i = 0 ; i < 7 ; i++ ){
			avanzaDia();
		}
	}
	
	public void avanzaMes(){
		mes += 1;
		if( mes > 12 ){
			año += 1;
			mes = 1;
		}
		normalizaDiaDentroDelMes();
	}

	private void normalizaDiaDentroDelMes() {
		int diasDeMes = diasDeMes(mes, año);
		if( dia > diasDeMes ){
			dia = diasDeMes;
		}
	}
	
	public void avanzaAño(){
		año += 1;
		normalizaDiaDentroDelMes();
	}
	
	private static int diasDeMes(int mes, int año) {
		int mesesNormales[]  = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int mesesBisiestos[] = {0,31,29,31,30,31,30,31,31,30,31,30,31};
		if( esBisiesto(año) )
			return mesesBisiestos[mes];
		else
			return mesesNormales[mes];
	}

	private static boolean esBisiesto(int año) {
		if( año % 400 == 0 ){
			return true;
		}
		if( año % 100 == 0 ){
			return false;
		}
		return año % 4 == 0;
	}

	@Override
	public String toString() {
		return String.format( "%02d/%02d/%d", dia,mes, año );
	}
	
	
	public static void main(String[] args) {
		Calendario c = new Calendario(31,1,2000);
		c.avanzaMes();
		System.out.println(c);
		c.avanzaAño();
		System.out.println(c);
	}
}
