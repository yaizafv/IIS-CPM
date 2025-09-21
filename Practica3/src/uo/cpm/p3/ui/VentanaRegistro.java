package uo.cpm.p3.ui;

import java.awt.EventQueue;

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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;

public class VentanaRegistro extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btSiguiente;
	private JPanel pnPedido;
	private JRadioButton btLocal;
	private JRadioButton btLlevar;
	private JButton btCancelar;
	private JPanel pnCliente;
	private JTextField txtNombreYApellidos;
	private JComboBox<String> cbAnios;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistro.class.getResource("/img/logo.png")));
		setTitle("McDonald´s España: Datos de registro");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
			btSiguiente.setMnemonic('S');
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
			btLocal.setMnemonic('l');
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
			btLlevar.setMnemonic('e');
			buttonGroup.add(btLlevar);
			btLlevar.setBackground(Color.WHITE);
			btLlevar.setBounds(118, 22, 65, 23);
		}
		return btLlevar;
	}

	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setMnemonic('C');
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
			pnCliente.add(getCbAnios());
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

	private JComboBox<String> getCbAnios() {
		if (cbAnios == null) {
			cbAnios = new JComboBox<String>();
			cbAnios.setModel(new DefaultComboBoxModel<String>(new String[] { "2010", "2009", "2008","2007","2006","2005","2004"}));
			cbAnios.setBounds(172, 70, 113, 22);
		}
		return cbAnios;
	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre y Apellidos:");
			lbNombre.setLabelFor(getTxtNombreYApellidos());
			lbNombre.setBounds(21, 35, 118, 14);
		}
		return lbNombre;
	}

	private JLabel getLbAño() {
		if (lbAño == null) {
			lbAño = new JLabel("Año de nacimiento:");
			lbAño.setLabelFor(getCbAnios());
			lbAño.setBounds(21, 74, 118, 14);
		}
		return lbAño;
	}

	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Password:");
			lbPassword.setLabelFor(getPasswordField());
			lbPassword.setBounds(21, 116, 88, 14);
		}
		return lbPassword;
	}

	private JLabel getLbRepeatPassword() {
		if (lbRepeatPassword == null) {
			lbRepeatPassword = new JLabel("Reintroduzca password:");
			lbRepeatPassword.setLabelFor(getRepeatPassword());
			lbRepeatPassword.setBounds(21, 163, 142, 14);
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
