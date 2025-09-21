package uo.cpm.p3.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class VentanaConfirmacion extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lbCheck;
	private JLabel lbPulseFinalizar;
	private JLabel lbCodigoRecogida;
	private JTextField txtCodigoRecogida;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConfirmacion dialog = new VentanaConfirmacion();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacion() {
		setTitle("McDonalds´s España: Confirmación de Pedido");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfirmacion.class.getResource("/img/logo.png")));
		setBounds(100, 100, 542, 279);
		getContentPane().setLayout(null);
		getContentPane().add(getLbCheck());
		getContentPane().add(getLbPulseFinalizar());
		getContentPane().add(getLbCodigoRecogida());
		getContentPane().add(getTxtCodigoRecogida());
		getContentPane().add(getBtnNewButton());

	}
	private JLabel getLbCheck() {
		if (lbCheck == null) {
			lbCheck = new JLabel("New label");
			lbCheck.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lbCheck.setBounds(51, 54, 52, 50);
		}
		return lbCheck;
	}
	private JLabel getLbPulseFinalizar() {
		if (lbPulseFinalizar == null) {
			lbPulseFinalizar = new JLabel("Pulse Finalizar para confirmar su pedido");
			lbPulseFinalizar.setFont(new Font("Arial Black", Font.PLAIN, 15));
			lbPulseFinalizar.setBounds(112, 64, 342, 27);
		}
		return lbPulseFinalizar;
	}
	private JLabel getLbCodigoRecogida() {
		if (lbCodigoRecogida == null) {
			lbCodigoRecogida = new JLabel("El código de recogida es: ");
			lbCodigoRecogida.setBounds(113, 142, 163, 14);
		}
		return lbCodigoRecogida;
	}
	private JTextField getTxtCodigoRecogida() {
		if (txtCodigoRecogida == null) {
			txtCodigoRecogida = new JTextField();
			txtCodigoRecogida.setEditable(false);
			txtCodigoRecogida.setBounds(266, 139, 86, 20);
			txtCodigoRecogida.setColumns(10);
		}
		return txtCodigoRecogida;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Finalizar");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(34, 139, 34));
			btnNewButton.setBounds(389, 206, 89, 23);
		}
		return btnNewButton;
	}
}
