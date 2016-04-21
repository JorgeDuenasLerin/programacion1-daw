package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class CalculadoraSimple extends JFrame {

	public CalculadoraSimple() {
		initComponents();
	}

	private void initComponents() {

		JTextField op1 = new JTextField();
		JTextField op2 = new JTextField();
		JLabel reslabel = new JLabel();
		reslabel.setText("Sin suma");
		JButton sumaButton = new JButton("");
		ImageIcon plusIcon = new ImageIcon(CalculadoraSimple.class.getResource("/swing/plus.png"));
		sumaButton.setIcon(plusIcon);
		JButton restaButton = new JButton("Resta");
		restaButton.setMnemonic('r');

		JPanel numerosPanel = new JPanel();
		numerosPanel.setLayout(new GridLayout(3, 1));
		numerosPanel.add(op1);
		numerosPanel.add(op2);
		numerosPanel.add(reslabel);
		getContentPane().add(numerosPanel, BorderLayout.CENTER);

		JPanel botonesPanel = new JPanel();
		botonesPanel.setLayout(new GridLayout(2, 1));
		botonesPanel.add(sumaButton);
		botonesPanel.add(restaButton);
		getContentPane().add(botonesPanel, BorderLayout.EAST);

		sumaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double v1 = Double.parseDouble(op1.getText());
					double v2 = Double.parseDouble(op2.getText());
					double res = v1 + v2;
					reslabel.setText(String.valueOf(res));
				} catch (NumberFormatException ex) {
					reslabel.setText("No son números ");
				}
			}
		});

		restaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double v1 = Double.parseDouble(op1.getText());
					double v2 = Double.parseDouble(op2.getText());
					double res = v1 - v2;
					reslabel.setText(String.valueOf(res));
				} catch (NumberFormatException ex) {
					reslabel.setText("No son números ");
				}
			}
		});

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new CalculadoraSimple();
	}

}
