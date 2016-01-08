
public class CuentaKilometros {

	private double distanciaTotalEnMetros = 0;
	private double distanciaParcialEnMetros = 0;

	public int getKilometros() {
		return pasarAKilometrosEnteros(distanciaTotalEnMetros);
	}

	private int pasarAKilometrosEnteros(double m) {
		return (int) Math.floor(m / 1000);
	}

	public int getKilometrosParcial() {
		return pasarAKilometrosEnteros(distanciaParcialEnMetros);
	}
	
	/**
	 * 
	 * @return 0 a 9
	 */
	int getHectometros() {
		return pasarAHectometros(distanciaTotalEnMetros);
	}

	private int pasarAHectometros(double m) {
		int hectometrosTotales = (int) (m / 100);
		return hectometrosTotales % 10;
	}

	/**
	 * 
	 * @return 0 a 9
	 */
	int getHectometrosParcial() {
		return pasarAHectometros(distanciaParcialEnMetros);
	}

	void inicializarParcial() {
		distanciaParcialEnMetros = 0;
	}

	void avanza(double metros) {
		if (metros < 0) {
			throw new IllegalArgumentException("Los metros no pueden ser negativos:" + metros);
		}
		distanciaParcialEnMetros += metros;
		distanciaTotalEnMetros += metros;
	}

	public String datosComoString() {
		return String.format("total: %d.%d parcial: %d.%d", getKilometros(), getHectometros(), getKilometrosParcial(),
				getHectometrosParcial());
	}

	public CuentaKilometros( int km, int hm ){
		if( hm < 0 || hm > 9 ){
			throw new IllegalArgumentException("hm mal:" + hm);
		}
		if( km < 0 ){
			throw new IllegalArgumentException("km mal:" + km);
		}
		distanciaTotalEnMetros = km*1000 + hm*100;
	}

	public CuentaKilometros(){
		this(0,0);
	}

	public boolean esMenorQue(CuentaKilometros c) {
		return comparar(this,c) == -1;
	}

	public boolean esMayorQue(CuentaKilometros c) {
		return comparar(this,c) == 1;
	}

	public boolean esIgualQue(CuentaKilometros c) {
		return comparar(this,c) == 0;
	}

	public static int comparar(CuentaKilometros c1, CuentaKilometros c2){
		double diferencia = c1.distanciaTotalEnMetros - c2.distanciaTotalEnMetros;
		return (int) Math.signum(diferencia);
		/*
		if( diferencia > 0 )
			return 1;
		else if( diferencia < 0 ){
			return -1;
		}
		else{
			return 0;
		}
		*/
	}

	
	public static void main(String[] args) {
		CuentaKilometros cm1 = new CuentaKilometros(123,9);

		System.out.println(cm1.datosComoString());
		
		cm1.avanza(1);
		
		System.out.println(cm1.datosComoString());

		cm1.avanza(99);
		System.out.println(cm1.datosComoString());
		
		cm1.inicializarParcial();
		System.out.println(cm1.datosComoString());

		cm1.avanza(1099);
		System.out.println(cm1.datosComoString());

		cm1.avanza(1);
		System.out.println(cm1.datosComoString());
		
		CuentaKilometros cm2 = new CuentaKilometros();
		System.out.println( comparar(cm1, cm2) );

		CuentaKilometros cm3 = new CuentaKilometros();
		System.out.println( comparar(cm3, cm2) );

		CuentaKilometros cm4 = new CuentaKilometros(1,0);
		System.out.println( comparar(cm3, cm4) );
		
		if( cm4.esMenorQue( cm3 ) ){
			
		}

	}

}
