
public class Calendario {

	private int dia;
	private int mes;
	private int a�o;
	
	public Calendario(){
		this(1,1,2016);
	}
	
	public Calendario(int dia, int mes, int a�o){
		this.dia = dia;
		this.mes = mes;
		this.a�o = a�o;
	}
	
	public void avanzaDia(){
		dia += 1;
		if( dia > diasDeMes(mes,a�o) ){
			dia = 1;
			mes +=1;
		}
		if( mes > 12 ){
			mes = 1;
			a�o += 1;
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
			a�o += 1;
			mes = 1;
		}
		normalizaDiaDentroDelMes();
	}

	private void normalizaDiaDentroDelMes() {
		int diasDeMes = diasDeMes(mes, a�o);
		if( dia > diasDeMes ){
			dia = diasDeMes;
		}
	}
	
	public void avanzaA�o(){
		a�o += 1;
		normalizaDiaDentroDelMes();
	}
	
	private static int diasDeMes(int mes, int a�o) {
		int mesesNormales[]  = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int mesesBisiestos[] = {0,31,29,31,30,31,30,31,31,30,31,30,31};
		if( esBisiesto(a�o) )
			return mesesBisiestos[mes];
		else
			return mesesNormales[mes];
	}

	private static boolean esBisiesto(int a�o) {
		if( a�o % 400 == 0 ){
			return true;
		}
		if( a�o % 100 == 0 ){
			return false;
		}
		return a�o % 4 == 0;
	}

	@Override
	public String toString() {
		return String.format( "%02d/%02d/%d", dia,mes, a�o );
	}
	
	
	public static void main(String[] args) {
		Calendario c = new Calendario(31,1,2000);
		c.avanzaMes();
		System.out.println(c);
		c.avanzaA�o();
		System.out.println(c);
	}
}
