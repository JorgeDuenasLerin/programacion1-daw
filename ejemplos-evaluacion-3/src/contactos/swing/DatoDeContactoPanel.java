package contactos.swing;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import contactos.jdbc.DatoDeContacto;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class DatoDeContactoPanel extends JPanel {
	private DatoDeContacto _datoDeContacto;
	private JComboBox<String> tipoCombo;
	private JComboBox<String> ambitoCombo;
	private JTextField valorText;

	/**
	 * Create the panel.
	 */
	public DatoDeContactoPanel() {
		
	
		initComponents();
	}

	private void initComponents() {
		tipoCombo = new JComboBox<>();
		tipoCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"Email", "Tel\u00E9fono", "Fax", "Direcci\u00F3n"}));
		
		ambitoCombo = new JComboBox<>();
		ambitoCombo.setModel(new DefaultComboBoxModel(new String[] {"Profesional", "Personal"}));
		
		valorText = new JTextField();
		valorText.setColumns(10);
		
		JButton borrarButton = new JButton("X");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tipoCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ambitoCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(valorText, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(borrarButton)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tipoCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ambitoCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(valorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(borrarButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	public void setDatoDeContacto(DatoDeContacto dc){
		_datoDeContacto = dc;
		delDatoDeContactoACampos();
	}

	public void delDatoDeContactoACampos() {
		// TODO: HAY QUE ASEGURARSE QUE LOS DATOS COINCIDEN CON LOS COMBOBOXES
		tipoCombo.setSelectedItem( _datoDeContacto.getTipo() );
		ambitoCombo.setSelectedItem( _datoDeContacto.getAmbito() );
		valorText.setText( _datoDeContacto.getValor() );
	}
	
	public void deCamposADatoDeContacto(){
		_datoDeContacto.setTipo((String) tipoCombo.getSelectedItem());
		_datoDeContacto.setAmbito( (String) ambitoCombo.getSelectedItem() );
		_datoDeContacto.setValor( valorText.getText() );
	}
	
	
}
