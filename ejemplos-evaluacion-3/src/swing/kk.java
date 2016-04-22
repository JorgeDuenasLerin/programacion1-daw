package swing;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class kk extends JPanel {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setContentPane( new kk() );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.aaaaaaaaakkkkk
	 */
	public kk() {
		JButton btnNewButton = new JButton("New button");
		
		JTextPane textPane = new JTextPane();
		
		JPanel panel = new JPanel();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField))
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textPane)
					.addGap(55)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(159)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton_3 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 0;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 2;
		panel_1.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JButton button = new JButton("New button");
		panel.add(button);
		this.setLayout(gl_contentPane);
	}
}
