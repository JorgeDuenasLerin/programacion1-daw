package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaConAvisoColocada extends JFrame{
	
	public VentanaConAvisoColocada(){
		initComponents();
	}

	private void initComponents() {
		setTitle("Mensaje");
		
		
		JLabel label = new JLabel( "Aviso importante para decidir si o no");
		
		label.addMouseListener( new MouseAdapter() {
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println(e);				
			}
		});
		
		
		label.setHorizontalAlignment( SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBackground(Color.pink);
		JButton aceptarButton = new JButton( "Aceptar");
		JButton cancelarButton = new JButton( "Cancelar");
		cancelarButton.setFont( Font.decode("Arial-bold-16") );
		cancelarButton.setBorderPainted(false);
		cancelarButton.setOpaque(false);
		
		cancelarButton.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Han dado en cancelar. Tú mismo.");
				label.setOpaque(false);
				label.repaint();
				
			}
		});
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout( new GridLayout(1, 2));
		panelBotones.add(aceptarButton);
		panelBotones.add(cancelarButton);
		

		setLayout( new BorderLayout() );
		
		add( label, BorderLayout.CENTER );
		
		
		add( panelBotones, BorderLayout.SOUTH );
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaConAvisoColocada();
	}

}
