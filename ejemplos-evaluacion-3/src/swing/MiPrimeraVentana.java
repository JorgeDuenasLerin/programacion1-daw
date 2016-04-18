package swing;

import javax.swing.JFrame;

public class MiPrimeraVentana extends JFrame{
	
	public MiPrimeraVentana(){
		init();
	}

	private void init() {
		setTitle("Mi primera ventana");
		setSize(640, 480);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MiPrimeraVentana();
		new MiPrimeraVentana();
		new MiPrimeraVentana();
		new MiPrimeraVentana();
		new MiPrimeraVentana();
	}
	
	

	
}
