
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

	public static void main(String[] args) {
		CuentaKilometros cm = new CuentaKilometros();

		System.out.println(cm.datosComoString());
		
		cm.avanza(1);
		
		System.out.println(cm.datosComoString());

		cm.avanza(99);
		System.out.println(cm.datosComoString());
		
		cm.inicializarParcial();
		System.out.println(cm.datosComoString());

		cm.avanza(1099);
		System.out.println(cm.datosComoString());

		cm.avanza(1);
		System.out.println(cm.datosComoString());

	}
}
