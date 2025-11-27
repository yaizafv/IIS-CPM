package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JButton btSig1;
	private JButton btAnt2;
	private JButton btSig2;
	private JButton btFinalizar3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanel1(), "panel1");
		contentPane.add(getPanel2(), "panel2");
		contentPane.add(getPanel3(), "panel3");
	}

	private JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setBackground(Color.YELLOW);
			panel1.setLayout(null);
			panel1.add(getBtSig1());
		}
		return panel1;
	}

	private JPanel getPanel2() {
		if (panel2 == null) {
			panel2 = new JPanel();
			panel2.setBackground(Color.BLUE);
			panel2.setLayout(null);
			panel2.add(getBtAnt2());
			panel2.add(getBtSig2());
		}
		return panel2;
	}

	private JPanel getPanel3() {
		if (panel3 == null) {
			panel3 = new JPanel();
			panel3.setBackground(Color.GREEN);
			panel3.setLayout(null);
			panel3.add(getBtFinalizar3());
		}
		return panel3;
	}

	private JButton getBtSig1() {
		if (btSig1 == null) {
			btSig1 = new JButton("Siguiente");
			btSig1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) contentPane.getLayout()).show(contentPane, "panel2");
					// ((CardLayout)contentPane.getLayout()).next(contentPane);
				}
			});
			btSig1.setBounds(268, 217, 89, 23);
		}
		return btSig1;
	}

	private JButton getBtAnt2() {
		if (btAnt2 == null) {
			btAnt2 = new JButton("Anterior");
			btAnt2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)contentPane.getLayout()).previous(contentPane);
				}
			});
			btAnt2.setBounds(229, 217, 89, 23);
		}
		return btAnt2;
	}

	private JButton getBtSig2() {
		if (btSig2 == null) {
			btSig2 = new JButton("Siguiente");
			btSig2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) contentPane.getLayout()).show(contentPane, "panel3");
				}
			});
			btSig2.setBounds(328, 217, 89, 23);
		}
		return btSig2;
	}
	private JButton getBtFinalizar3() {
		if (btFinalizar3 == null) {
			btFinalizar3 = new JButton("Finalizar");
			btFinalizar3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) contentPane.getLayout()).show(contentPane, "panel1");
				}
			});
			btFinalizar3.setBounds(296, 217, 89, 23);
		}
		return btFinalizar3;
	}
}
