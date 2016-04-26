package swing.contactos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ContactoPanel extends JPanel {
	private JTextField nombreText;
	private JTextField apellidosText;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	private Contacto _contacto;
	private boolean _dirty;
	private JButton imagenLabel;

	public Contacto getContacto() {
		return _contacto;
	}

	public void setContacto(Contacto _contacto) {
		this._contacto = _contacto;
		deContactoACampos();
	}

	private void deContactoACampos() {
		Contacto c = getContacto();
		nombreText.setText(c.getNombre());
		apellidosText.setText(c.getApellidos());

		{
			byte[] imagen = c.getImagen();
			try {
				InputStream in = null;
				if (imagen == null) {
					in = getClass().getResourceAsStream("/swing/contactos/sin-imagen.png");
				} else {
					in = new ByteArrayInputStream(imagen);
				}
				imagenLabel.setIcon(new ImageIcon( ImageIO.read(in)));
				imagenLabel.setText("");

			} catch (IOException e) {
				// DEJO LA IMAGEN VACIA O COMO ESTUVIERA
				imagenLabel.setIcon(null);
				imagenLabel.setText("Imagen incorrecta");
				e.printStackTrace();
			}
		}

		setDirty(false);
	}

	private void deCamposAContacto() {
		Contacto c = getContacto();
		System.err.println("Antes de cambiar el contacto:" + c);

		c.setNombre(nombreText.getText());
		c.setApellidos(apellidosText.getText());
		
		{
			ImageIcon icon = (ImageIcon) imagenLabel.getIcon();
			BufferedImage i = (BufferedImage) icon.getImage();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			try {
				ImageIO.write(i, "png", out);
				out.flush();
				c.setImagen( out.toByteArray() );
			} catch (IOException e) {
				// NO DEBERIA FALLAR PORQUE VA DE MEMORIA A MEMORIA,
				// DEJO LA TRAZA POR SI ACASO
				e.printStackTrace();
			}
			
			
			
		}
		

		System.err.println("Después de cambiar el contacto:" + c);

		setDirty(false);
	}
	
	private void seleccionarOtraImagen() {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(this);
		File f = chooser.getSelectedFile();
		if( f != null ){
			try {
				BufferedImage i = ImageIO.read(f);
				imagenLabel.setIcon( new ImageIcon(i) );
				setDirty(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private void setDirty(boolean b) {
		_dirty = b;
		if (_dirty) {
			setOpaque(true);
			setBackground(Color.pink);
		} else {
			setOpaque(false);
		}
		repaint();
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		ContactoPanel p = new ContactoPanel();
		Contacto c = new Contacto();
		c.setNombre("Álvaro");
		p.setContacto(c);
		f.getContentPane().add(p, BorderLayout.CENTER);

		JButton b = new JButton("Grabar");
		b.addActionListener((a) -> p.deCamposAContacto());
		f.getContentPane().add(b, BorderLayout.SOUTH);

		f.pack();
		f.setVisible(true);
	}

	/**
	 * Create the panel.
	 */
	public ContactoPanel() {
		initComponents();

		DocumentListener listener = new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				setDirty(true);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				setDirty(true);

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				setDirty(true);
			}
		};
		nombreText.getDocument().addDocumentListener(listener);
		apellidosText.getDocument().addDocumentListener(listener);

	}

	private void initComponents() {
		JLabel lblNombre = new JLabel("Nombre");

		JLabel lblApellidos = new JLabel("Apellidos");

		JSeparator separator = new JSeparator();

		imagenLabel = new JButton("imagenlabel");
		imagenLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarOtraImagen();
			}
		});

		nombreText = new JTextField();
		nombreText.setColumns(10);

		apellidosText = new JTextField();
		apellidosText.setColumns(10);

		JButton btnAadirCampo = new JButton("A\u00F1adir campo");

		JPanel camposAdicionalesPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNombre)
								.addComponent(lblApellidos))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(nombreText, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE).addComponent(
										apellidosText, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(imagenLabel).addContainerGap())
				.addComponent(separator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(btnAadirCampo)
						.addContainerGap(333, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(camposAdicionalesPanel, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout
						.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false).addComponent(imagenLabel,
								Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(
										Alignment.LEADING, groupLayout
												.createSequentialGroup().addGap(21)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(nombreText, GroupLayout.PREFERRED_SIZE, 20,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNombre))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblApellidos).addComponent(apellidosText,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE).addGap(1)
						.addComponent(btnAadirCampo).addGap(11).addComponent(camposAdicionalesPanel,
								GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(37, Short.MAX_VALUE)));

		JLabel lblNewLabel = new JLabel("Email");

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Personal", "Profesional" }));

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnX = new JButton("X");

		JLabel label = new JLabel("Email");

		JComboBox comboBox_1 = new JComboBox();

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton button = new JButton("X");

		JLabel label_1 = new JLabel("Email");

		JComboBox comboBox_2 = new JComboBox();

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JButton button_1 = new JButton("X");

		JLabel label_2 = new JLabel("Email");

		JComboBox comboBox_3 = new JComboBox();

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		JButton button_2 = new JButton("X");
		GroupLayout gl_camposAdicionalesPanel = new GroupLayout(camposAdicionalesPanel);
		gl_camposAdicionalesPanel.setHorizontalGroup(
				gl_camposAdicionalesPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_camposAdicionalesPanel
						.createSequentialGroup().addGap(24).addGroup(gl_camposAdicionalesPanel.createParallelGroup(
								Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_camposAdicionalesPanel
										.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 85,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
										.addGap(6).addComponent(button_1, GroupLayout.PREFERRED_SIZE, 41,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING,
										gl_camposAdicionalesPanel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 85,
														GroupLayout.PREFERRED_SIZE)
												.addGap(6)
												.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 226,
														Short.MAX_VALUE)
												.addGap(6).addComponent(button_2, GroupLayout.PREFERRED_SIZE, 41,
														GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_camposAdicionalesPanel.createSequentialGroup()
										.addGroup(gl_camposAdicionalesPanel
												.createParallelGroup(Alignment.TRAILING, false)
												.addGroup(gl_camposAdicionalesPanel.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblNewLabel).addGap(18).addComponent(comboBox, 0,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(gl_camposAdicionalesPanel.createSequentialGroup()
														.addComponent(label, GroupLayout.PREFERRED_SIZE, 24,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18).addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE,
																85, GroupLayout.PREFERRED_SIZE)))
										.addGap(6)
										.addGroup(gl_camposAdicionalesPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(Alignment.TRAILING,
														gl_camposAdicionalesPanel.createSequentialGroup()
																.addComponent(textField_1, GroupLayout.DEFAULT_SIZE,
																		226, Short.MAX_VALUE)
																.addGap(6).addComponent(button,
																		GroupLayout.PREFERRED_SIZE, 41,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(Alignment.TRAILING,
														gl_camposAdicionalesPanel.createSequentialGroup()
																.addComponent(textField)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnX)))))
						.addContainerGap()));
		gl_camposAdicionalesPanel.setVerticalGroup(gl_camposAdicionalesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_camposAdicionalesPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_camposAdicionalesPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnX).addComponent(lblNewLabel))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_camposAdicionalesPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_camposAdicionalesPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(label))
								.addGroup(gl_camposAdicionalesPanel.createSequentialGroup().addGap(1).addComponent(
										textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
								.addComponent(button))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_camposAdicionalesPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_camposAdicionalesPanel.createSequentialGroup().addGap(4)
										.addComponent(label_1))
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_camposAdicionalesPanel.createSequentialGroup().addGap(1).addComponent(
										textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
								.addComponent(button_1))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_camposAdicionalesPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_camposAdicionalesPanel.createSequentialGroup().addGap(4)
										.addComponent(label_2))
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_camposAdicionalesPanel.createSequentialGroup().addGap(1).addComponent(
										textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
								.addComponent(button_2))
						.addContainerGap(45, Short.MAX_VALUE)));
		camposAdicionalesPanel.setLayout(gl_camposAdicionalesPanel);
		setLayout(groupLayout);

	}
}
