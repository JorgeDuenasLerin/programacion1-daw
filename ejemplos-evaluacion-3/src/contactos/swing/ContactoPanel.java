package contactos.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import contactos.jdbc.DatoDeContacto;

public class ContactoPanel extends JPanel {
	private JTextField nombreText;
	private JTextField apellidosText;

	private Contacto _contacto;
	private boolean _dirty;
	private JButton imagenLabel;
	private JScrollPane camposAdicionalesScrollPanel;
	private JPanel camposAdicionalesPanel;

	public Contacto getContacto() {
		return _contacto;
	}

	public void setContacto(Contacto _contacto) {
		this._contacto = _contacto;
		deContactoACampos();
	}

	public void deContactoACampos() {
		Contacto c = getContacto();
		nombreText.setText(c.getNombre());
		apellidosText.setText(c.getApellidos());

		{
			byte[] imagen = c.getImagen();
			try {
				InputStream in = null;
				if (imagen == null) {
					in = getClass().getResourceAsStream("/contactos/swing/sin-imagen.png");
				} else {
					in = new ByteArrayInputStream(imagen);
				}
				BufferedImage image = ImageIO.read(in);
				if (image == null) {
					throw new IOException();
				}
				ImageIcon icon = new ImageIcon(image);
				imagenLabel.setIcon(icon);
				imagenLabel.setText("");

			} catch (IOException e) {
				// DEJO LA IMAGEN VACIA O COMO ESTUVIERA
				imagenLabel.setIcon(null);
				imagenLabel.setText("Imagen incorrecta");
				e.printStackTrace();
			}
		}

		actualizaCamposAdicionalesPanelConContacto();

		setDirty(false);
	}

	private void actualizaCamposAdicionalesPanelConContacto() {
		camposAdicionalesPanel.removeAll();
		int rows = _contacto.getDatosDeContacto().size();
		camposAdicionalesPanel.setLayout(new GridLayout(rows, 1));

		for (DatoDeContacto dc : _contacto.getDatosDeContacto()) {
			DatoDeContactoPanel dcp = new DatoDeContactoPanel();
			dcp.setDatoDeContacto(dc);
			camposAdicionalesPanel.add(dcp);
		}
		
		repintaLaVentanaHaciendoQueCambieDeSize();
			 
	}

	private void repintaLaVentanaHaciendoQueCambieDeSize() {
		Window w = SwingUtilities.getWindowAncestor(this);
		int h = w.getHeight();
		w.setSize(w.getWidth(),h+1);
		SwingUtilities.invokeLater( new Runnable(){
			@Override
			public void run(){
				w.setSize(w.getWidth(),h);
			}
		});
	}

	private void actualizaContactoDesdeCamposAdicionalesPanel() {
		for (int i = 0; i < camposAdicionalesPanel.getComponentCount(); i++) {
			DatoDeContactoPanel dcp = (DatoDeContactoPanel) camposAdicionalesPanel.getComponent(i);
			dcp.deCamposADatoDeContacto();
		}
	}

	public void deCamposAContacto() {
		Contacto c = getContacto();
		System.err.println("Antes de cambiar el contacto:" + c);

		c.setNombre(nombreText.getText());
		c.setApellidos(apellidosText.getText());

		{
			ImageIcon icon = (ImageIcon) imagenLabel.getIcon();
			if (icon != null) {
				BufferedImage i = (BufferedImage) icon.getImage();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				try {
					ImageIO.write(i, "png", out);
					out.flush();
					c.setImagen(out.toByteArray());
				} catch (IOException e) {
					// NO DEBERIA FALLAR PORQUE VA DE MEMORIA A MEMORIA,
					// DEJO LA TRAZA POR SI ACASO
					e.printStackTrace();
				}
			}
		}

		actualizaContactoDesdeCamposAdicionalesPanel();

		System.err.println("Después de cambiar el contacto:" + c);

		setDirty(false);
	}

	private void seleccionarOtraImagen() {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(this);
		File f = chooser.getSelectedFile();
		if (f != null) {
			try {
				BufferedImage i = ImageIO.read(f);
				imagenLabel.setIcon(new ImageIcon(i));
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
		btnAadirCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarDatoDeContacto();
			}
		});

		camposAdicionalesPanel = new JPanel();

		camposAdicionalesScrollPanel = new JScrollPane(camposAdicionalesPanel);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre)
						.addComponent(lblApellidos))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(nombreText, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
						.addComponent(apellidosText, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(imagenLabel)
					.addContainerGap())
				.addComponent(separator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(btnAadirCampo)
					.addContainerGap(333, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(camposAdicionalesScrollPanel, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(imagenLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(nombreText, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblApellidos)
								.addComponent(apellidosText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(btnAadirCampo)
					.addGap(11)
					.addComponent(camposAdicionalesScrollPanel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addGap(28))
		);
		camposAdicionalesPanel.setLayout(new GridLayout(0, 1, 0, 0));
		setLayout(groupLayout);

	}

	protected void agregarDatoDeContacto() {
		_contacto.addDato( new DatoDeContacto("", "", "<sin valor>") );
		
		actualizaCamposAdicionalesPanelConContacto();
		
	}
}
