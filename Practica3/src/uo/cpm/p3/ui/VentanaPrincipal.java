package uo.cpm.p3.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPrecioPedido;
	private JLabel lbArticulos;
	private JComboBox cbArticulos;
	private JLabel lbUnidades;
	private JButton btAnadir;
	private JLabel lbPrecioPedido;
	private JButton btSiguiente;
	private JButton btCancelar;
	private JSpinner spUnidades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setResizable(false);
		setTitle("McDonald´s España");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 390);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
		lbLogo.setBounds(26, 42, 153, 130);
		contentPane.add(lbLogo);
		
		spUnidades = new JSpinner();
		spUnidades.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spUnidades.setBounds(217, 213, 30, 20);
		contentPane.add(spUnidades);
		
		JLabel lbMcDonalds = new JLabel("McDonald´s");
		lbMcDonalds.setFont(new Font("Arial Black", Font.PLAIN, 40));
		lbMcDonalds.setBounds(189, 94, 281, 31);
		contentPane.add(lbMcDonalds);
		
		txtPrecioPedido = new JTextField();
		txtPrecioPedido.setEditable(false);
		txtPrecioPedido.setBounds(271, 271, 86, 20);
		contentPane.add(txtPrecioPedido);
		txtPrecioPedido.setColumns(10);
		contentPane.add(getLbArticulos());
		contentPane.add(getCbArticulos());
		contentPane.add(getLbUnidades());
		contentPane.add(getBtAnadir());
		contentPane.add(getLbPrecioPedido());
		contentPane.add(getBtSiguiente());
		contentPane.add(getBtCancelar());

	}
	private JLabel getLbArticulos() {
		if (lbArticulos == null) {
			lbArticulos = new JLabel("Artículos:");
			lbArticulos.setDisplayedMnemonic('r');
			lbArticulos.setLabelFor(getCbArticulos());
			lbArticulos.setBounds(26, 190, 57, 14);
		}
		return lbArticulos;
	}
	private JComboBox getCbArticulos() {
		if (cbArticulos == null) {
			cbArticulos = new JComboBox();
			cbArticulos.setBounds(26, 212, 30, 22);
		}
		return cbArticulos;
	}
	private JLabel getLbUnidades() {
		if (lbUnidades == null) {
			lbUnidades = new JLabel("Unidades:");
			lbUnidades.setDisplayedMnemonic('u');
			lbUnidades.setLabelFor(spUnidades);
			lbUnidades.setBounds(217, 188, 63, 14);
		}
		return lbUnidades;
	}
	private JButton getBtAnadir() {
		if (btAnadir == null) {
			btAnadir = new JButton("Añadir");
			btAnadir.setForeground(new Color(255, 255, 255));
			btAnadir.setBackground(new Color(34, 139, 34));
			btAnadir.setMnemonic('A');
			btAnadir.setBounds(271, 212, 89, 23);
		}
		return btAnadir;
	}
	private JLabel getLbPrecioPedido() {
		if (lbPrecioPedido == null) {
			lbPrecioPedido = new JLabel("Precio Pedido:");
			lbPrecioPedido.setLabelFor(txtPrecioPedido);
			lbPrecioPedido.setBounds(271, 246, 86, 14);
		}
		return lbPrecioPedido;
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setMnemonic('S');
			btSiguiente.setForeground(Color.WHITE);
			btSiguiente.setBackground(new Color(34, 139, 34));
			btSiguiente.setBounds(419, 317, 89, 23);
		}
		return btSiguiente;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setMnemonic('C');
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setBackground(new Color(255, 0, 0));
			btCancelar.setBounds(528, 317, 89, 23);
		}
		return btCancelar;
	}
}
