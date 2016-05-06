package contactos.swing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResumenContactoPanel extends JPanel {

	private Contacto contacto;
	private JLabel icon;
	private JLabel nombre;
	private JLabel apellido;

	/**
	 * Create the panel.
	 */
	public ResumenContactoPanel() {
		initComponents();
	}

	
	public void setContacto(Contacto c){
		contacto = c;
		
		nombre.setText(c.getNombre());
		apellido.setText(c.getApellidos());
		
		{
			byte[] imagen = c.getImagen();
			try {
				InputStream in = null;
				if (imagen == null) {
					in = getClass().getResourceAsStream("/contactos/swing/sin-imagen.png");
				} else {
					in = new ByteArrayInputStream(imagen);
				}
				icon.setIcon(new ImageIcon( ImageIO.read(in)));
				icon.setText("");

			} catch (IOException e) {
				// DEJO LA IMAGEN VACIA O COMO ESTUVIERA
				icon.setIcon(null);
				icon.setText("Imagen incorrecta");
				e.printStackTrace();
			}
		}
		
	}
	
	private void initComponents() {
		// TODO Auto-generated method stub

		icon = new JLabel("New label");

		nombre = new JLabel("New label");
		nombre.setFont(new Font("Wide Latin", Font.PLAIN, 14));

		apellido = new JLabel("New label");
		apellido.setFont(new Font("Wide Latin", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(icon)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(nombre, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(apellido,
												GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING,
												groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(nombre)
														.addComponent(apellido))
										.addGroup(Alignment.TRAILING,
												groupLayout.createSequentialGroup().addContainerGap().addComponent(icon,
														GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
								.addContainerGap()));
		setLayout(groupLayout);

	}

}
