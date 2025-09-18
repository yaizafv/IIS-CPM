package uo.cpm.p2.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;
import javax.swing.ButtonGroup;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btSiguiente;
	private JPanel pnPedido;
	private JRadioButton btLocal;
	private JRadioButton btLlevar;
	private JButton btCancelar;
	private JPanel pnCliente;
	private JTextField txtNombreYApellidos;
	private JComboBox comboBox;
	private JLabel lbNombre;
	private JLabel lbAño;
	private JLabel lbPassword;
	private JLabel lbRepeatPassword;
	private JPasswordField passwordField;
	private JPasswordField repeatPassword;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setTitle("Datos de registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 413);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtSiguiente());
		contentPane.add(getPnPedido());
		contentPane.add(getBtCancelar());
		contentPane.add(getPnCliente());
	}

	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkTxtBlank();
					checkPassword();
				}
			});
			btSiguiente.setForeground(Color.WHITE);
			btSiguiente.setBackground(new Color(34, 139, 34));
			btSiguiente.setBounds(497, 340, 89, 23);
		}
		return btSiguiente;
	}

	private void checkTxtBlank() {
		if (getTxtNombreYApellidos().getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Nombre y apellidos en blanco");
		}
	}

	private void checkPassword() {
		String pass1 = String.valueOf(getPasswordField().getPassword());
	    String pass2 = String.valueOf(getRepeatPassword().getPassword());

	    if (!pass1.equals(pass2)) {
	        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
	    }
	}

	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setBorder(new TitledBorder(null, "Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnPedido.setBackground(Color.WHITE);
			pnPedido.setBounds(21, 300, 201, 63);
			pnPedido.setLayout(null);
			pnPedido.add(getBtLocal());
			pnPedido.add(getBtLlevar());
		}
		return pnPedido;
	}

	private JRadioButton getBtLocal() {
		if (btLocal == null) {
			btLocal = new JRadioButton("Local");
			buttonGroup.add(btLocal);
			btLocal.setSelected(true);
			btLocal.setBackground(Color.WHITE);
			btLocal.setBounds(17, 22, 72, 23);
		}
		return btLocal;
	}

	private JRadioButton getBtLlevar() {
		if (btLlevar == null) {
			btLlevar = new JRadioButton("Llevar");
			buttonGroup.add(btLlevar);
			btLlevar.setBackground(Color.WHITE);
			btLlevar.setBounds(118, 22, 65, 23);
		}
		return btLlevar;
	}

	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finalizar();
				}
			});
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setBackground(Color.RED);
			btCancelar.setBounds(596, 340, 89, 23);
		}
		return btCancelar;
	}

	private void finalizar() {
		System.exit(0);
	}

	private JPanel getPnCliente() {
		if (pnCliente == null) {
			pnCliente = new JPanel();
			pnCliente.setBackground(Color.WHITE);
			pnCliente.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnCliente.setBounds(21, 24, 676, 252);
			pnCliente.setLayout(null);
			pnCliente.add(getTxtNombreYApellidos());
			pnCliente.add(getComboBox());
			pnCliente.add(getLbNombre());
			pnCliente.add(getLbAño());
			pnCliente.add(getLbPassword());
			pnCliente.add(getLbRepeatPassword());
			pnCliente.add(getPasswordField());
			pnCliente.add(getRepeatPassword());
		}
		return pnCliente;
	}

	private JTextField getTxtNombreYApellidos() {
		if (txtNombreYApellidos == null) {
			txtNombreYApellidos = new JTextField();
			txtNombreYApellidos.setBounds(173, 33, 325, 20);
			txtNombreYApellidos.setColumns(10);
		}
		return txtNombreYApellidos;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "2010" }));
			comboBox.setBounds(172, 70, 113, 22);
		}
		return comboBox;
	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre y Apellidos");
			lbNombre.setBounds(21, 35, 118, 14);
		}
		return lbNombre;
	}

	private JLabel getLbAño() {
		if (lbAño == null) {
			lbAño = new JLabel("Año de nacimiento");
			lbAño.setBounds(21, 74, 105, 14);
		}
		return lbAño;
	}

	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Password");
			lbPassword.setBounds(21, 116, 88, 14);
		}
		return lbPassword;
	}

	private JLabel getLbRepeatPassword() {
		if (lbRepeatPassword == null) {
			lbRepeatPassword = new JLabel("Reintroduzca password");
			lbRepeatPassword.setBounds(21, 163, 135, 14);
		}
		return lbRepeatPassword;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(173, 116, 179, 18);
		}
		return passwordField;
	}

	private JPasswordField getRepeatPassword() {
		if (repeatPassword == null) {
			repeatPassword = new JPasswordField();
			repeatPassword.setBounds(173, 161, 179, 18);
		}
		return repeatPassword;
	}
}
