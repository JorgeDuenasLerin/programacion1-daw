
public class Calendario {

	private int dia;
	private int mes;
	
	public Calendario(){
		dia = 1;
		mes = 1;
	}
	
	public void avanzaDia(){
		dia += 1;
		if( dia > diasDemes(mes) ){
			dia = 1;
			mes +=1;
		}
		if( mes > 12 ){
			mes = 1;
		}
	}
	
	private int diasDemes(int mes) {
		int meses[] = {0,31,29,31,30,31,30,31,31,30,31,30,31};
		return meses[mes];
	}

	@Override
	public String toString() {
		return String.format( "%02d/%02d", dia,mes );
	}
	
	public static void main(String[] args) {
		Calendario c = new Calendario();
		for( int i = 0 ; i < 366*2 ; c.avanzaDia(), i++ ){
			System.out.println(c);
		}
	}
}
