package swing;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.TreeModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VentanaRendimiento extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
	 * @throws IOException 
	 */
	public VentanaRendimiento() throws IOException {
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
		memoriaPanelo.setLayout( new BorderLayout() );
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
		panel_4.setLayout( new BorderLayout() );
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
		
		ImagenQueSeEstira lblAquVaLa_1 = new ImagenQueSeEstira("/swing/grafica-memoria.png");
		panel_4.add(lblAquVaLa_1);
		
		JLabel lblAquVaLa = new JLabel("Aqu\u00ED va la gr\u00E1fica de la cpu");
		panel_3.add(lblAquVaLa);
		
		ImagenQueSeEstira lblNewLabel_9 = new ImagenQueSeEstira("/swing/memoria.png");
		memoriaPanelo.add(lblNewLabel_9);
		
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
		
		
		
		DefaultListModel<String> procesos = new DefaultListModel<>();
		for( String s: new String[] {"Excel", "Word", "Eclipse", "Spotify"} ){
			procesos.addElement(s);
		}
		for( String s: new String[] {"Excel", "Word", "Eclipse", "Spotify"} ){
			procesos.addElement(s);
		}
		for( String s: new String[] {"Excel", "Word", "Eclipse", "Spotify"} ){
			procesos.addElement(s);
		}
		for( String s: new String[] {"Excel", "Word", "Eclipse", "Spotify"} ){
			procesos.addElement(s);
		}
		for( String s: new String[] {"Excel", "Word", "Eclipse", "Spotify"} ){
			procesos.addElement(s);
		}
		for( String s: new String[] {"Excel", "Word", "Eclipse", "Spotify"} ){
			procesos.addElement(s);
		}
		for( String s: new String[] {"Excel", "Word", "Eclipse", "Spotify"} ){
			procesos.addElement(s);
		}
		procesos.addListDataListener( new ListDataListener() {
			
			@Override
			public void intervalRemoved(ListDataEvent e) {
				System.out.println(e);
				
			}
			
			@Override
			public void intervalAdded(ListDataEvent e) {
				System.out.println(e);
				
			}
			
			@Override
			public void contentsChanged(ListDataEvent e) {
				System.out.println(e);
				
			}
		});
		
		JList list = new JList();
		list.setModel(procesos);
		JScrollPane scrollPane = new JScrollPane(list);
		
		JList list2 = new JList();
		list2.setModel(list.getModel());
		JScrollPane scrollPane2 = new JScrollPane(list2);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setRightComponent(scrollPane);
		splitPane.setLeftComponent(scrollPane2);
		
		JPanel tabDeProcesos = new JPanel();
		tabDeProcesos.setLayout( new BorderLayout() );
		tabDeProcesos.add(splitPane,BorderLayout.CENTER);
		
		JButton  matarProceso = new JButton("Matar proceso");
		matarProceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if( index == -1 ){
					System.out.println("No mato nada, no hay seleccionado");
					return;
				}
				DefaultListModel model = (DefaultListModel) list.getModel();
				model.remove(index);
				
			}
		});
		tabDeProcesos.add( matarProceso, BorderLayout.SOUTH );
		
		tabbedPane.addTab("LISTA de procesos", null, tabDeProcesos, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("TABLA de procesos", null, panel_5, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_5.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"word", "1", "32"},
				{"excel", "2", "1324"},
				{"eclipse", "3", "1324"},
				{"java", "4", "134"},
				{"java", "5", null},
			},
			new String[] {
				"Nombre de imagen", "CPU", "Memoria"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		JSplitPane splitDeArbol = new JSplitPane();
		panel_6.add(splitDeArbol);
		
		splitDeArbol.setLeftComponent(scrollPane_2);
		
		JEditorPane editor = new JEditorPane();
		JScrollPane scrollPane_3 = new JScrollPane(editor);
		splitDeArbol.setRightComponent(scrollPane_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e);
			}
		});
		scrollPane_3.setColumnHeaderView(comboBox);
		
		comboBox.setModel( new DefaultComboBoxModel( new String[]{"uno","dos","tres","cuatro"} ) );
		
		
		JTree tree = new JTree();
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if( e.getClickCount() == 2 ){
					File f = (File) tree.getSelectionPath().getLastPathComponent();
					System.out.println("Me han hecho doble click en:" + f );
					try{
						FileInputStream in = new FileInputStream(f);
						Reader reader = new InputStreamReader(in);
						StringBuffer b = new StringBuffer();
						int c = reader.read();
						while( c != -1 ){
							b.append((char)c);
							c = reader.read();
						}
						editor.setText(b.toString());
					}
					catch( IOException ex ){
						ex.printStackTrace();
					}
				}
			}
		});
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				System.out.println("Seleccionado el fichero:" + e.getPath().getLastPathComponent() );
			}
		});
		tree.setModel( new TreeModelDeFicheros() );
		scrollPane_2.setViewportView(tree);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
	}
	
	
	private class TreeModelDeFicheros implements TreeModel{

		@Override
		public Object getRoot() {
			return new File("C:/");
		}

		@Override
		public Object getChild(Object parent, int index) {
			File f = (File) parent;
			File[] files = f.listFiles();
			return files[index];
		}

		@Override
		public int getChildCount(Object parent) {
			File f = (File) parent;
			File[] files = f.listFiles();
			if( files == null ){
				return 0;
			}
			return files.length;
		}

		@Override
		public boolean isLeaf(Object node) {
			return getChildCount(node) == 0;
		}

		@Override
		public void valueForPathChanged(TreePath path, Object newValue) {
			System.out.println("No soportado:" + path );
			
		}

		@Override
		public int getIndexOfChild(Object parent, Object child) {
			return 0;
		}

		@Override
		public void addTreeModelListener(TreeModelListener l) {
		}

		@Override
		public void removeTreeModelListener(TreeModelListener l) {
		}
		
	}
	
	/**
	 * Componente que pinta una imagen ajustada a su tamaño 
	 * @author agonzalez
	 */
	static public class ImagenQueSeEstira extends JComponent{
		private Image _img;
		
		/**
		 * @param img La imagen a pintar (se puede conseguir con ImageIO)
		 */
		public ImagenQueSeEstira(Image img){
			_img = img;
			setOpaque(false);
		}
		
		/**
		 * @param resourceName El nombre del recurso (no es un nombre del fichero, es el nombre dentro del classpath)
		 * @throws IOException
		 */
		public ImagenQueSeEstira(String resourceName) throws IOException{
			this( ImageIO.read( ImagenQueSeEstira.class.getResourceAsStream(resourceName) ) );
		}
		
		
		/**
		 * Pinto la imagen ajustada al tamaño actual del componente
		 * @param g La brocha de pintar
		 */
		@Override
		public void paint(Graphics g) {
			int w = getWidth();
			int h = getHeight();
			
			if( isOpaque() ){
				// SI ES OPACO (NO SE VE LO QUE HAY DETRAS), RELLENO EL FONDO DE MI COLOR DE FONDO
				g.setColor( getBackground() );
				g.fillRect(0, 0, w, h);
			}
			
			// PINTO LA IMAGEN ENTERA (0,0,iw,ih) EN EL COMPONENTE COMPLETO (0,0,w,h)
			int iw = _img.getWidth(null);
			int ih = _img.getHeight(null);
			g.drawImage(_img, 0, 0, w, h, 0, 0, iw, ih, null);
		}
		/**
		 * 
		 * @return El tamaño de la imagen original (es mi tamaño preferido)
		 */
		@Override
		public Dimension getPreferredSize() {
			int iw = _img.getWidth(null);
			int ih = _img.getHeight(null);

			return new Dimension(iw,ih); 
		}
		
	}
	
	
}
