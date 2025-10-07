package uo.cpm.p4.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo.cpm.p4.model.Articulo;
import uo.cpm.p4.service.McDonalds;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPrecioPedido;
	private JLabel lbArticulos;
	private JComboBox<Articulo> cbArticulos;
	private JLabel lbUnidades;
	private JButton btAnadir;
	private JLabel lbPrecioPedido;
	private JButton btSiguiente;
	private JButton btCancelar;
	private JSpinner spUnidades;
	private McDonalds mcDonalds;
	private JLabel lblUds;
	private JButton btEliminar;
	private JToggleButton tgPedido;
	private JTextArea textAreaPedido;
	private JScrollPane scrollPanePedido;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(McDonalds mcDonalds) {
		this.mcDonalds = mcDonalds;
		setResizable(false);
		setTitle("McDonald´s España");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 390);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(getLbLogo());
		contentPane.add(getLbMcDonalds());
		contentPane.add(getLbArticulos());
		contentPane.add(getCbArticulos());
		contentPane.add(getLbUnidades());
		contentPane.add(getBtAnadir());
		contentPane.add(getLbPrecioPedido());
		contentPane.add(getTxtPrecioPedido());
		contentPane.add(getSpUnidades());
		contentPane.add(getBtSiguiente());
		contentPane.add(getBtCancelar());
		contentPane.add(getLblUds());
		contentPane.add(getBtEliminar());
		contentPane.add(getTgPedido());
		contentPane.add(getScrollPanePedido());
	}

	private JLabel getLbLogo() {
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
		lbLogo.setBounds(26, 42, 153, 130);
		return lbLogo;

	}

	private JLabel getLbMcDonalds() {
		JLabel lbMcDonalds = new JLabel("McDonald´s");
		lbMcDonalds.setFont(new Font("Arial Black", Font.PLAIN, 40));
		lbMcDonalds.setBounds(189, 94, 281, 31);
		return lbMcDonalds;
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

	private JComboBox<Articulo> getCbArticulos() {
		if (cbArticulos == null) {
			cbArticulos = new JComboBox<Articulo>();
			cbArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reinicio();
					eliminarNoDisponible((Articulo)cbArticulos.getSelectedItem());
				}
			});
			cbArticulos.setModel(new DefaultComboBoxModel<Articulo>(mcDonalds.getArticulosCarta()));
			cbArticulos.setBounds(26, 212, 280, 22);
		}
		return cbArticulos;
	}

	private void reinicio() {
		getSpUnidades().setValue(1);
		lblUds = new JLabel("");
		lblUds.setEnabled(false);
	}

	private void textoUnidades() {
		int totalUnidades = mcDonalds.getUnidadesArticulo((Articulo) getCbArticulos().getSelectedItem());
		if (totalUnidades == 0) {
			getLblUds().setText("");
			getLblUds().setEnabled(false);
		} else {
			getLblUds().setText("Hay " + totalUnidades + " uds de este articulo en el pedido");
		}
	}

	private JLabel getLbUnidades() {
		if (lbUnidades == null) {
			lbUnidades = new JLabel("Unidades:");
			lbUnidades.setDisplayedMnemonic('u');
			lbUnidades.setLabelFor(spUnidades);
			lbUnidades.setBounds(339, 188, 63, 14);
		}
		return lbUnidades;
	}

	private JButton getBtAnadir() {
		if (btAnadir == null) {
			btAnadir = new JButton("Añadir");
			btAnadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aniadirAPedido();
				}
			});
			btAnadir.setForeground(new Color(255, 255, 255));
			btAnadir.setBackground(new Color(34, 139, 34));
			btAnadir.setMnemonic('A');
			btAnadir.setBounds(406, 212, 89, 23);
		}
		return btAnadir;
	}

	private void aniadirAPedido() {
		Articulo articuloSeleccionado = (Articulo) getCbArticulos().getSelectedItem();
		int unidadesSolicitadas = (int) getSpUnidades().getValue();
		mcDonalds.aniadirAPedido(articuloSeleccionado, unidadesSolicitadas);
		String precio = String.format("%.2f", mcDonalds.getPrecioArticulos());
		getTxtPrecioPedido().setText(precio + " €");
		textoUnidades();
		if (!getBtSiguiente().isEnabled()) {
			getBtSiguiente().setEnabled(true);
		}
		eliminarNoDisponible(articuloSeleccionado);
	}

	private JTextField getTxtPrecioPedido() {
		if (txtPrecioPedido == null) {
			txtPrecioPedido = new JTextField();
			txtPrecioPedido.setEditable(false);
			txtPrecioPedido.setBounds(339, 270, 71, 31);
			txtPrecioPedido.setColumns(10);
		}
		return txtPrecioPedido;
	}

	private JSpinner getSpUnidades() {
		if (spUnidades == null) {
			spUnidades = new JSpinner();
			spUnidades
					.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
			spUnidades.setBounds(339, 212, 51, 23);
		}
		return spUnidades;
	}

	public McDonalds getMcDonalds() {
		return mcDonalds;
	}

	private JLabel getLbPrecioPedido() {
		if (lbPrecioPedido == null) {
			lbPrecioPedido = new JLabel("Precio Pedido:");
			lbPrecioPedido.setLabelFor(txtPrecioPedido);
			lbPrecioPedido.setBounds(339, 245, 86, 14);
		}
		return lbPrecioPedido;
	}

	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setEnabled(false);
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					llamarVentanaRegistro();
				}
			});
			btSiguiente.setMnemonic('S');
			btSiguiente.setForeground(Color.WHITE);
			btSiguiente.setBackground(new Color(34, 139, 34));
			btSiguiente.setBounds(419, 317, 89, 23);
		}
		return btSiguiente;
	}

	private void llamarVentanaRegistro() {
		VentanaRegistro frame = new VentanaRegistro(this);
		frame.setVisible(true);
	}

	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			btCancelar.setMnemonic('C');
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setBackground(new Color(255, 0, 0));
			btCancelar.setBounds(528, 317, 89, 23);
		}
		return btCancelar;
	}

	public void inicializar() {
		mcDonalds.inicializarPedido();
		getCbArticulos().setSelectedIndex(0);
		reinicio();
		getTxtPrecioPedido().setText("");
		getBtSiguiente().setEnabled(false);
	}

	private JLabel getLblUds() {
		if (lblUds == null) {
			lblUds = new JLabel("");
			lblUds.setEnabled(false);
			lblUds.setFont(new Font("Arial", Font.PLAIN, 12));
			lblUds.setForeground(Color.RED);
			lblUds.setBounds(26, 258, 261, 14);
		}
		return lblUds;
	}

	private JButton getBtEliminar() {
		if (btEliminar == null) {
			btEliminar = new JButton("Eliminar");
			getBtEliminar().setEnabled(false);
			btEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminar();
				}				
			});
			btEliminar.setForeground(new Color(255, 255, 255));
			btEliminar.setMnemonic('E');
			btEliminar.setBackground(new Color(34, 139, 34));
			btEliminar.setBounds(505, 212, 89, 23);
		}
		return btEliminar;
	}
	
	private void eliminar() {
		Articulo articuloAEliminar = (Articulo) getCbArticulos().getSelectedItem();
		int unidades = (int) getSpUnidades().getValue();
		mcDonalds.eliminar(articuloAEliminar, unidades);
		String precio = String.format("%.2f", mcDonalds.getPrecioArticulos());
		getTxtPrecioPedido().setText(precio + " €");
		textoUnidades();
		getSpUnidades().setValue(1);	
		eliminarNoDisponible(articuloAEliminar);
	}
	
	private void eliminarNoDisponible(Articulo articulo) {
		if (mcDonalds.estaEnPedido(articulo)){
			getBtEliminar().setEnabled(true);
		} else {
			getBtEliminar().setEnabled(false);
		}
	}
	private JToggleButton getTgPedido() {
		if (tgPedido == null) {
			tgPedido = new JToggleButton("Pedido");
			tgPedido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPedido();
				}
			});
			tgPedido.setMnemonic('p');
			tgPedido.setFont(new Font("Arial Black", Font.PLAIN, 11));
			tgPedido.setBackground(new Color(255, 196, 15));
			tgPedido.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/pedido.png")));
			tgPedido.setBounds(492, 10, 125, 53);
		}
		return tgPedido;
	}
	
	private void mostrarPedido() {
		getTextAreaPedido().setText(mcDonalds.mostrarPedido());
	}
	
	private JTextArea getTextAreaPedido() {
		if (textAreaPedido == null) {
			textAreaPedido = new JTextArea();
			textAreaPedido.setWrapStyleWord(true);
			textAreaPedido.setLineWrap(true);
		}
		return textAreaPedido;
	}
	private JScrollPane getScrollPanePedido() {
		if (scrollPanePedido == null) {
			scrollPanePedido = new JScrollPane();
			scrollPanePedido.setBounds(450, 73, 167, 80);
			scrollPanePedido.setViewportView(getTextAreaPedido());
		}
		return scrollPanePedido;
	}
}
