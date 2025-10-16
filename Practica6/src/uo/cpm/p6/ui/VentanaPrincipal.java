package uo.cpm.p6.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo.cpm.p6.model.Articulo;
import uo.cpm.p6.service.McDonalds;

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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

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
	private JLabel lblmgArticulo;
	private JMenuBar menuBar;
	private JMenu mnPedido;
	private JMenu mnAyuda;
	private JMenuItem miNuevo;
	private JMenuItem miSalir;
	private JSeparator separator;
	private JMenuItem miContenidos;
	private JMenuItem menuItem;
	private JMenuItem miAcercaDe;
	private JSeparator separator_1;
	private JPanel panelFiltro;
	private JButton btHamburguesas;
	private JButton btTodos;
	private JButton btComplementos;
	private JButton btBebidas;
	private JButton btPostres;
	
	class ProcesaAccion implements ActionListener {
		private String tipo;
		
		public ProcesaAccion (String tipo) {
			this.tipo = tipo;
		}

		public void actionPerformed(ActionEvent e) {
			filtrarArticulos(tipo);
		}
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(McDonalds mcDonalds) {
		this.mcDonalds = mcDonalds;
		setResizable(false);
		setTitle("McDonald´s España");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 472);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
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
		contentPane.add(getLblmgArticulo());
		contentPane.add(getMenuItem());
		contentPane.add(getPanelFiltro());
	}

	private JLabel getLbLogo() {
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
		lbLogo.setBounds(22, 43, 153, 130);
		return lbLogo;

	}

	private JLabel getLbMcDonalds() {
		JLabel lbMcDonalds = new JLabel("McDonald´s");
		lbMcDonalds.setFont(new Font("Arial Black", Font.PLAIN, 40));
		lbMcDonalds.setBounds(185, 104, 281, 31);
		return lbMcDonalds;
	}

	private JLabel getLbArticulos() {
		if (lbArticulos == null) {
			lbArticulos = new JLabel("Artículos:");
			lbArticulos.setDisplayedMnemonic('r');
			lbArticulos.setLabelFor(getCbArticulos());
			lbArticulos.setBounds(20, 187, 57, 14);
		}
		return lbArticulos;
	}

	private JComboBox<Articulo> getCbArticulos() {
		if (cbArticulos == null) {
			cbArticulos = new JComboBox<Articulo>();
			cbArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reinicio();
					eliminarNoDisponible((Articulo) cbArticulos.getSelectedItem());
					mostrarImagenArticulo();
				}
			});
			cbArticulos.setModel(new DefaultComboBoxModel<Articulo>(mcDonalds.getArticulosCarta()));
			cbArticulos.setBounds(20, 212, 335, 22);
		}
		return cbArticulos;
	}

	private void mostrarImagenArticulo() {
		String fortoArticulo = "/img/" + ((Articulo) cbArticulos.getSelectedItem()).getCodigo() + ".png";
		getLblmgArticulo().setIcon(new ImageIcon(VentanaPrincipal.class.getResource(fortoArticulo)));
	}

	private void filtrarArticulos(String tipo) {
		getCbArticulos().setModel(new DefaultComboBoxModel<Articulo>(mcDonalds.getProducto(tipo)));
		if (getCbArticulos().getModel().getSize() > 0) {
			getCbArticulos().setSelectedIndex(0);
			mostrarImagenArticulo();
		}
	}

	private void reinicio() {
		getSpUnidades().setValue(1);
		textoUnidades();
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
			lbUnidades.setBounds(365, 187, 63, 14);
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
			btAnadir.setBounds(498, 212, 89, 23);
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
		mostrarPedido();

	}

	private JTextField getTxtPrecioPedido() {
		if (txtPrecioPedido == null) {
			txtPrecioPedido = new JTextField();
			txtPrecioPedido.setEditable(false);
			txtPrecioPedido.setBounds(498, 306, 71, 31);
			txtPrecioPedido.setColumns(10);
		}
		return txtPrecioPedido;
	}

	private JSpinner getSpUnidades() {
		if (spUnidades == null) {
			spUnidades = new JSpinner();
			spUnidades
					.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
			spUnidades.setBounds(365, 212, 51, 23);
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
			lbPrecioPedido.setBounds(498, 281, 86, 14);
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
			btSiguiente.setBounds(498, 377, 89, 23);
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
			btCancelar.setBounds(597, 377, 89, 23);
		}
		return btCancelar;
	}

	public void inicializar() {
		mcDonalds.inicializarPedido();
		filtrarArticulos("Todos");
		getCbArticulos().setSelectedIndex(0);
		reinicio();
		getTxtPrecioPedido().setText("");
		getBtSiguiente().setEnabled(false);
		mostrarPedido();
	}

	private JLabel getLblUds() {
		if (lblUds == null) {
			lblUds = new JLabel("");
			lblUds.setEnabled(false);
			lblUds.setFont(new Font("Arial", Font.PLAIN, 12));
			lblUds.setForeground(Color.RED);
			lblUds.setBounds(22, 245, 258, 22);
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
			btEliminar.setBounds(597, 212, 89, 23);
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
		mostrarPedido();
	}

	private void eliminarNoDisponible(Articulo articulo) {
		if (mcDonalds.estaEnPedido(articulo)) {
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
			tgPedido.setBackground(new Color(255, 187, 13));
			tgPedido.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/pedido.png")));
			tgPedido.setBounds(561, 11, 125, 53);
		}
		return tgPedido;
	}

	private void mostrarPedido() {
		if (getTgPedido().isSelected() && !mcDonalds.getListaPedido().isEmpty()) {
			getTextAreaPedido().setText(mcDonalds.mostrarPedido());
		}
	}

	private JTextArea getTextAreaPedido() {
		if (textAreaPedido == null) {
			textAreaPedido = new JTextArea();
			textAreaPedido.setEditable(false);
			textAreaPedido.setWrapStyleWord(true);
			textAreaPedido.setLineWrap(true);
		}
		return textAreaPedido;
	}

	private JScrollPane getScrollPanePedido() {
		if (scrollPanePedido == null) {
			scrollPanePedido = new JScrollPane();
			scrollPanePedido.setBounds(503, 60, 183, 113);
			scrollPanePedido.setViewportView(getTextAreaPedido());
		}
		return scrollPanePedido;
	}

	private JLabel getLblmgArticulo() {
		if (lblmgArticulo == null) {
			lblmgArticulo = new JLabel("");
			mostrarImagenArticulo();
			lblmgArticulo.setBounds(91, 267, 175, 155);
		}
		return lblmgArticulo;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnPedido());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}

	private JMenu getMnPedido() {
		if (mnPedido == null) {
			mnPedido = new JMenu("Pedido");
			mnPedido.setMnemonic('d');
			mnPedido.add(getMiNuevo());
			mnPedido.add(getSeparator());
			mnPedido.add(getMiSalir());
		}
		return mnPedido;
	}

	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('y');
			mnAyuda.add(getMiContenidos());
			mnAyuda.add(getSeparator_1());
			mnAyuda.add(getMiAcercaDe());
		}
		return mnAyuda;
	}

	private JMenuItem getMiNuevo() {
		if (miNuevo == null) {
			miNuevo = new JMenuItem("Nuevo");
			miNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			miNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			miNuevo.setMnemonic('n');
		}
		return miNuevo;
	}

	private JMenuItem getMiSalir() {
		if (miSalir == null) {
			miSalir = new JMenuItem("Salir");
			miSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(EXIT_ON_CLOSE);
				}
			});
			miSalir.setMnemonic('s');
		}
		return miSalir;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private JMenuItem getMiContenidos() {
		if (miContenidos == null) {
			miContenidos = new JMenuItem("Contenidos");
			miContenidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			miContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			miContenidos.setMnemonic('c');
			miContenidos.setEnabled(false);
		}
		return miContenidos;
	}

	private JMenuItem getMenuItem() {
		if (menuItem == null) {
			menuItem = new JMenuItem("New menu item");
			menuItem.setBounds(38, 11, -195, 200);
		}
		return menuItem;
	}

	private JMenuItem getMiAcercaDe() {
		if (miAcercaDe == null) {
			miAcercaDe = new JMenuItem("Acerca de");
			miAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane
							.showMessageDialog(null,
									"Aplicacion para TPV de comida rapida \nRealizada por Yaiza Vega \n"
											+ "Practicas CPM 25-26 \nEII Oviedo",
									"Acerca de", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			miAcercaDe.setMnemonic('a');
		}
		return miAcercaDe;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}

	private JPanel getPanelFiltro() {
		if (panelFiltro == null) {
			panelFiltro = new JPanel();
			panelFiltro.setBounds(729, 0, 106, 400);
			panelFiltro.setLayout(new GridLayout(5, 1, 0, 0));
			panelFiltro.add(getBtTodos());
			panelFiltro.add(getBtHamburguesas());
			panelFiltro.add(getBtBebidas());
			panelFiltro.add(getBtComplementos());
			panelFiltro.add(getBtPostres());
		}
		return panelFiltro;
	}

	private JButton getBtHamburguesas() {
		if (btHamburguesas == null) {
			btHamburguesas = new JButton("");
			btHamburguesas.addActionListener(new ProcesaAccion("Hamburguesa"));
			btHamburguesas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Hamburguesa.png")));
			btHamburguesas.setMnemonic('h');
		}
		return btHamburguesas;
	}

	private JButton getBtTodos() {
		if (btTodos == null) {
			btTodos = new JButton("");
			btTodos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Todos.png")));
			btTodos.setMnemonic('d');
			btTodos.addActionListener(new ProcesaAccion("Todos"));
		}
		return btTodos;
	}

	private JButton getBtComplementos() {
		if (btComplementos == null) {
			btComplementos = new JButton("");
			btComplementos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Complemento.png")));
			btComplementos.setMnemonic('m');
			btComplementos.addActionListener(new ProcesaAccion("Complemento"));
		}
		return btComplementos;
	}

	private JButton getBtBebidas() {
		if (btBebidas == null) {
			btBebidas = new JButton("");
			btBebidas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Bebida.png")));
			btBebidas.setMnemonic('b');
			btBebidas.addActionListener(new ProcesaAccion("Bebida"));
		}
		return btBebidas;
	}

	private JButton getBtPostres() {
		if (btPostres == null) {
			btPostres = new JButton("");
			btPostres.setVerticalTextPosition(SwingConstants.BOTTOM);
			btPostres.setHorizontalTextPosition(SwingConstants.CENTER);
			btPostres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Postre.png")));
			btPostres.setMnemonic('o');
			btPostres.addActionListener(new ProcesaAccion("Postre"));
		}
		return btPostres;
	}
}
