package swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaConAvisoSinColocar extends JFrame{
	
	public VentanaConAvisoSinColocar(){
		initComponents();
	}

	private void initComponents() {
		setTitle("Mensaje");
		
		setLayout(null); // no coloques tú las cosas, ya lo hago yo
		
		JLabel label = new JLabel( "Aviso importante para decidir si o no");
		JButton aceptarButton = new JButton( "Aceptar");
		JButton cancelarButton = new JButton( "Cancelar");
		
		label.setLocation(100, 100);
		label.setSize(100, 100);
		
		aceptarButton.setLocation(200, 100);
		aceptarButton.setSize(100, 100);

		cancelarButton.setLocation(300, 100);
		cancelarButton.setSize(100, 100);
		
		add( label );
		add( aceptarButton );
		add( cancelarButton );
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaConAvisoSinColocar();
	}

}
