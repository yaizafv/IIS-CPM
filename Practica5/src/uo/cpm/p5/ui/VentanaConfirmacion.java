package uo.cpm.p5.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConfirmacion extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lbCheck;
	private JLabel lbPulseFinalizar;
	private JLabel lbCodigoRecogida;
	private JTextField txtCodigoRecogida;
	private JButton btFinalizar;
	private VentanaRegistro vr;
	private JLabel lblPrecioTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacion(VentanaRegistro vr) {
		setModal(true);
		this.vr = vr;
		setTitle("McDonalds´s España: Confirmación de Pedido");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfirmacion.class.getResource("/img/logo.png")));
		setBounds(100, 100, 542, 279);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(getLbCheck());
		getContentPane().add(getLbPulseFinalizar());
		getContentPane().add(getLbCodigoRecogida());
		getContentPane().add(getTxtCodigoRecogida());
		getContentPane().add(getBtFinalizar());
		getContentPane().add(getLblPrecioTotal());

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
			txtCodigoRecogida.setText(vr.getVp().getMcDonalds().getCodigoPedido());
			txtCodigoRecogida.setEditable(false);
			txtCodigoRecogida.setBounds(265, 136, 95, 27);
			txtCodigoRecogida.setColumns(10);
		}
		return txtCodigoRecogida;
	}
	private JButton getBtFinalizar() {
		if (btFinalizar == null) {
			btFinalizar = new JButton("Finalizar");
			btFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finalizar();
				}
			});
			btFinalizar.setForeground(new Color(255, 255, 255));
			btFinalizar.setBackground(new Color(34, 139, 34));
			btFinalizar.setBounds(389, 206, 89, 23);
		}
		return btFinalizar;
	}
	
	private void finalizar() {
		vr.getVp().getMcDonalds().grabarPedido();
		JOptionPane.showMessageDialog(null, "Muchas gracias por el pedido. \nRecogelo en el mostrador");
		dispose();
		vr.dispose();
		vr.getVp().inicializar();
		
	}
	
	private JLabel getLblPrecioTotal() {
		if (lblPrecioTotal == null) {
			lblPrecioTotal = new JLabel(" ");
			lblPrecioTotal.setBounds(112, 182, 184, 14);
			lblPrecioTotal.setText("El precio total es de " + vr.getVp().getMcDonalds().getImportePedido() + " €");
		}
		return lblPrecioTotal;
	}
}
