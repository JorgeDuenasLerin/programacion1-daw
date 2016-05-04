package contactos.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import contactos.jdbc.ConexionBD;
import contactos.jdbc.ContactoDAO;

public class ContactoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ContactoPanel contactoPanel;
	private boolean aceptado = false;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		editaContactoConID(1);
	}
	
	

	public Contacto getContacto() {
		return contactoPanel.getContacto();
	}



	public void setContacto(Contacto contacto) {
		contactoPanel.setContacto(contacto);
	}
	



	/**
	 * Create the dialog.
	 */
	public ContactoDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			contactoPanel = new ContactoPanel();
			contentPanel.add(contactoPanel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aceptar();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelar();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}



	protected void cancelar() {
		System.out.println("Cancelado");
		aceptado = false;
		setVisible(false);
	}



	protected void aceptar() {
		System.out.println("Aceptado");
		contactoPanel.deCamposAContacto();
		aceptado = true;
		setVisible(false);
	}
	
	public static void editaContactoConID( int id ) throws SQLException{
		
		Connection connection = ConexionBD.creaConexion();
		Contacto c = ContactoDAO.buscarPorID(connection ,id);
		ContactoDialog dialog = new ContactoDialog();
		dialog.setContacto(c);
		dialog.setModal(true);
		dialog.setVisible(true);
		boolean aceptado = dialog.isAceptado();
		System.out.println("El dialogo es aceptado:" + aceptado );
		if( aceptado ){
			System.out.println("Modificando");
			ContactoDAO.modificaContacto(connection, c);
		}
		connection.close();
	}



	private boolean isAceptado() {
		return aceptado;
	}


}
