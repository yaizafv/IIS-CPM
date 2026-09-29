package uo.cpm.examen.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo.cpm.examen.service.Service;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbDni;
	private JTextField txtDni;
	private JButton btSiguiente;

	private Service sv;

	public VentanaPrincipal(Service sv) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.jpg")));
		setTitle("Cine");
		setResizable(false);
		this.sv = sv;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbDni());
		contentPane.add(getTxtDni());
		contentPane.add(getBtSiguiente());
		inicializar();
	}

	public void inicializar() {
		sv.inicializar();
		sv.limpiarVip();
		reiniciarBotones();
	}
	
	private void reiniciarBotones() {
		getBtSiguiente().setEnabled(false);
	}

	private JLabel getLbDni() {
		if (lbDni == null) {
			lbDni = new JLabel("Introduce tu dni:");
			lbDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbDni.setBounds(81, 104, 141, 30);
		}
		return lbDni;
	}

	private JTextField getTxtDni() {
		if (txtDni == null) {
			txtDni = new JTextField();
			txtDni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					activarBtSiguiente();
					guardarDni();
				}
			});
			txtDni.setBounds(217, 106, 129, 30);
			txtDni.setColumns(10);
		}
		return txtDni;
	}

	private void activarBtSiguiente() {
		if (!getTxtDni().getText().isEmpty())
			getBtSiguiente().setEnabled(true);
	}

	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setEnabled(false);
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					llamarVentanaPeliculas();
				}
			});
			btSiguiente.setMnemonic('s');
			btSiguiente.setBackground(new Color(0, 128, 0));
			btSiguiente.setBounds(337, 214, 89, 23);
		}
		return btSiguiente;
	}

	private void guardarDni() {
		sv.guardarDni(getTxtDni().getText());
	}

	private void llamarVentanaPeliculas() {
		VentanaPeliculas frame = new VentanaPeliculas(this);
		frame.setVisible(true);
		dispose();
	}

	public Service getSv() {
		return sv;
	}
}
