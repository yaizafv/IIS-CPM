package uo.cpm.examen.ui;


import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo.cpm.examen.model.Pelicula;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;

public class VentanaPeliculas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private VentanaPrincipal vP;
	private JLabel lbVip;
	private JScrollPane scrollPane;
	private JList<Pelicula> listPeliculas;
	private DefaultListModel<Pelicula> modelListPeliculas;
	private JSpinner spinner;
	private JLabel lbEntradas;
	private JLabel lbPrecio;
	private JLabel lbPrecioNum;
	private JButton btSeleccionar;

	/**
	 * Create the frame.
	 * 
	 * @param ventanaPrincipal
	 */
	public VentanaPeliculas(VentanaPrincipal vP) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPeliculas.class.getResource("/img/logo.jpg")));
		setTitle("Cine: Peliculas");
		setResizable(false);
		this.vP = vP;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbVip());
		contentPane.add(getScrollPane());
		contentPane.add(getSpinner());
		contentPane.add(getLbEntradas());
		contentPane.add(getLbPrecio());
		contentPane.add(getLbPrecioNum());
		contentPane.add(getBtSeleccionar());

	}

	private JLabel getLbVip() {
		if (lbVip == null) {
			lbVip = new JLabel("");
			lbVip.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbVip.setBounds(33, 74, 90, 23);
			esVip();
		}
		return lbVip;
	}

	private void esVip() {
		if (vP.getSv().isVip()) {
			getLbVip().setText("Eres vip");
		} else {
			getLbVip().setText("No eres vip");
		}
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(33, 108, 320, 116);
			scrollPane.setViewportView(getListPeliculas());
		}
		return scrollPane;
	}

	private JList<Pelicula> getListPeliculas() {
		if (listPeliculas == null) {
			modelListPeliculas = new DefaultListModel<Pelicula>();
			listPeliculas = new JList<Pelicula>(modelListPeliculas);
			listPeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listPeliculas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					activarBotones();
					ponerSpinnerInicial();
				}
			});
			cargarPeliculas();
			
		}
		return listPeliculas;
	}
	
	private void ponerSpinnerInicial() {
		getSpinner().setValue(1);
	}
	
	private void activarBotones() {
		getSpinner().setEnabled(true);
		getBtSeleccionar().setEnabled(true);
	}
	
	private void desactivarBotones() {
		getSpinner().setEnabled(false);
		getBtSeleccionar().setEnabled(false);
	}

	private void cargarPeliculas() {
		modelListPeliculas.addAll(vP.getSv().getPeliculas());

	}

	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setEnabled(false);
			spinner.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					calcularNumeroEntradas();
					calcularPrecio();
				}
			});
			spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
			spinner.setBounds(452, 107, 41, 20);
		}
		return spinner;
	}
	
	private void calcularNumeroEntradas() {
		vP.getSv().setNumEntradas((int) getSpinner().getValue());
	}
	
	private void calcularPrecio() {
		float precio = vP.getSv().calcularPrecio(getListPeliculas().getSelectedValue());
		getLbPrecioNum().setText(String.valueOf(precio));
	}

	private JLabel getLbEntradas() {
		if (lbEntradas == null) {
			lbEntradas = new JLabel("Entradas:");
			lbEntradas.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbEntradas.setBounds(381, 104, 72, 23);
		}
		return lbEntradas;
	}

	private JLabel getLbPrecio() {
		if (lbPrecio == null) {
			lbPrecio = new JLabel("Precio:");
			lbPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbPrecio.setBounds(381, 154, 46, 23);
		}
		return lbPrecio;
	}

	private JLabel getLbPrecioNum() {
		if (lbPrecioNum == null) {
			lbPrecioNum = new JLabel("");
			lbPrecioNum.setBounds(437, 154, 46, 23);
		}
		return lbPrecioNum;
	}

	private JButton getBtSeleccionar() {
		if (btSeleccionar == null) {
			btSeleccionar = new JButton("Confirmar");
			btSeleccionar.setEnabled(false);
			btSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					llamarVentanaJuego();
				}
			});
			btSeleccionar.setBackground(new Color(0, 128, 0));
			btSeleccionar.setMnemonic('s');
			btSeleccionar.setBounds(381, 201, 112, 23);
		}
		return btSeleccionar;
	}
	
	private void llamarVentanaJuego() {
		VentanaJuego frame = new VentanaJuego(this);
		frame.setVisible(true);
		dispose();
		
	}
	
	public VentanaPrincipal getVp() {
		return vP;
	}

	public void inicializar() {
		ponerSpinnerInicial();
		desactivarBotones();
		getLbVip().setText("");
		vP.inicializar();
		
	}
}
