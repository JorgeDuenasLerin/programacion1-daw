package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaRendimiento extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRendimiento frame = new VentanaRendimiento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRendimiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 472);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mnArchivo.add(mntmCerrar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		JMenuItem mntmAlgo = new JMenuItem("Algo");
		mnOpciones.add(mntmAlgo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Rendimiento", null, panel_1, null);
		
		JPanel mFisicaPanel = new JPanel();
		mFisicaPanel.setBorder(new TitledBorder(null, "Memoria f\u00EDsica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		
		JPanel memoriaPanelo = new JPanel();
		memoriaPanelo.setBorder(new TitledBorder(null, "Memoria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel sistemaPanel = new JPanel();
		panel_1.add(sistemaPanel);
		sistemaPanel.setBorder(new TitledBorder(null, "Memoria f\u00EDsica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sistemaPanel.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel label = new JLabel("Total");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		sistemaPanel.add(label);
		
		JLabel label_1 = new JLabel("132");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		sistemaPanel.add(label_1);
		
		JLabel label_2 = new JLabel("En cach\u00E9");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		sistemaPanel.add(label_2);
		
		JLabel label_3 = new JLabel("1324");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		sistemaPanel.add(label_3);
		
		JLabel label_4 = new JLabel("Disponible");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		sistemaPanel.add(label_4);
		
		JLabel label_5 = new JLabel("46");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		sistemaPanel.add(label_5);
		
		JLabel label_6 = new JLabel("Libre");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		sistemaPanel.add(label_6);
		
		JLabel label_7 = new JLabel("4632");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		sistemaPanel.add(label_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "CPU", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Historial de la CPU", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Historial de uso de memoria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(memoriaPanelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
						.addComponent(sistemaPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(mFisicaPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
						.addComponent(memoriaPanelo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sistemaPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mFisicaPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(0))
		);
		
		JLabel lblAquVaLa_1 = new JLabel("Aqu\u00ED va la gr\u00E1fica de la memoria");
		panel_4.add(lblAquVaLa_1);
		
		JLabel lblAquVaLa = new JLabel("Aqu\u00ED va la gr\u00E1fica de la cpu");
		panel_3.add(lblAquVaLa);
		
		JLabel lblNewLabel_9 = new JLabel("");
		memoriaPanelo.add(lblNewLabel_9);
		lblNewLabel_9.setIcon(new ImageIcon(VentanaRendimiento.class.getResource("/swing/memoria.png")));
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(VentanaRendimiento.class.getResource("/swing/cpu.png")));
		panel_2.add(lblNewLabel_8);
		mFisicaPanel.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Total");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mFisicaPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("132");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		mFisicaPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("En cach\u00E9");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		mFisicaPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("1324");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		mFisicaPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Disponible");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		mFisicaPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("46");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		mFisicaPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Libre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		mFisicaPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_7 = new JLabel("4632");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		mFisicaPanel.add(lblNewLabel_7);
		panel_1.setLayout(gl_panel_1);
		
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
	}
}
