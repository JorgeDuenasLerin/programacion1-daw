package swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PruebaConUnThread extends JFrame{
	private JTextPane textPane;
	public PruebaConUnThread() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);
		getContentPane().add( scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		
		JButton conThreadButton = new JButton("Proceso largo con thread");
		conThreadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conThread();
			}
		});
		panel.add(conThreadButton);
		
		JButton sinThreadButton = new JButton("ProcesoLargoSinThread");
		sinThreadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sinThread();
			}

			
		});
		panel.add(sinThreadButton);
	}

	protected void conThread() {
		new Thread( new Runnable(){
			public void run(){
				procesoLargo();
			}
		}).start();
		
	}

	private void sinThread() {
		procesoLargo();
		
	}

	private void procesoLargo() {
		for( int i = 0 ; i < 10000 ; i ++ ){
			Document document = textPane.getDocument();
			try {
				document.insertString( document.getLength(), "\nCadena " + i, null);
				Thread.sleep(10);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		JFrame f = new PruebaConUnThread();
		f.pack();
		f.setVisible(true);
	}
}

