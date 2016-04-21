package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class VentanaConContador extends JFrame{
	private JTable table;
	private final JSpinner spinner = new JSpinner();


	public VentanaConContador(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichero = new JMenu("Fichero");
		menuBar.add(mnFichero);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mnFichero.add(mntmAbrir);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mnFichero.add(mntmCerrar);
		
		JMenu mnEdicin = new JMenu("Edici\u00F3n");
		menuBar.add(mnEdicin);
		
		JMenuItem mntmCopiar = new JMenuItem("Copiar");
		mnEdicin.add(mntmCopiar);
		
		JMenu mnPegar = new JMenu("Pegar");
		mnEdicin.add(mnPegar);
		
		JMenuItem mntmComoTexto = new JMenuItem("Como texto");
		mnPegar.add(mntmComoTexto);
		
		JMenuItem mntmComoGrfico = new JMenuItem("Como Gr\u00E1fico");
		mnPegar.add(mntmComoGrfico);
		initComponents();
	}
	
	
	interface Op{
		int op(int a, int b);
	}
	
	private void initComponents() {
		getContentPane().setLayout(new BorderLayout() );
		
		JTextField texto = new JTextField("0");
		JButton botonDeIncrementar = new JButton("Pulsa para incrementar");
		botonDeIncrementar.setMnemonic('p');
		
		getContentPane().add( texto, BorderLayout.WEST);
		getContentPane().add( botonDeIncrementar, BorderLayout.SOUTH);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				algoPasaConElSpinner(e);
			}
		});
		getContentPane().add(spinner, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setRightComponent(tabbedPane);
		
		JTree tree = new JTree();
		tabbedPane.addTab("New tab", null, tree, null);
		
		JTree tree_1 = new JTree();
		tabbedPane.addTab("New tab", null, tree_1, null);
		
		table = new JTable();
		tabbedPane.addTab("New tab", null, table, null);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println(e);
				JSlider s = (JSlider)e.getSource();
				System.out.println(s.getValue());
			}
		});
		slider.setMaximum(1000);
		slider.setMinimum(15);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(300);
		slider.setMinorTickSpacing(100);
		slider.setPaintTicks(true);
		tabbedPane.addTab("New tab", null, slider, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, BorderLayout.NORTH);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		panel.add(chckbxNewCheckBox, BorderLayout.WEST);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		panel.add(rdbtnNewRadioButton, BorderLayout.EAST);
		
		JTextArea textArea = new JTextArea();
		panel.add( new JScrollPane(textArea), BorderLayout.CENTER);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		panel.add(tglbtnNewToggleButton, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.add(panel_2);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		panel_2.add(rdbtnNewRadioButton_1);
		
		JTree tree_2 = new JTree();
		panel_2.add(tree_2);
		
		JLabel lblAdsfdasfdasf = new JLabel("adsfdasfdasf");
		lblAdsfdasfdasf.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(lblAdsfdasfdasf);
		
		JRadioButton rdbtnAdsfasd = new JRadioButton("adsfasd");
		rdbtnAdsfasd.setBorder(new TitledBorder(null, "un borde", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(rdbtnAdsfasd);
		
		
		// ESTO SOLO FUNCIONA EN JDK 8 (LAMBDAS)
		Op op = (a,b) -> a+b;
		
		botonDeIncrementar.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s = texto.getText();
				try{
					int i = Integer.parseInt(s);
					texto.setText( ""+ op.op(i,1) );
				}
				catch( NumberFormatException e ){
					texto.setText( "no es un número" );
				}
			}
			
		});
		
		setVisible(true);
	}



	protected void algoPasaConElSpinner(ChangeEvent e) {
		System.out.println(e);

		
	}



	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.invokeLater( new Runnable(){
			@Override
			public void run() {
				new VentanaConContador();
			}
		});
	}
}
