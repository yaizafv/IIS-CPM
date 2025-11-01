package uo.cpm.p7.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;

import uo.cpm.p7.model.Nivel;
import uo.cpm.p7.service.SpaceInvaders;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btDado;
	private JLabel lbNave;
	private JLabel lbTierra;
	private JTextField txtPuntos;
	private JTextField txtPuntos2;
	private JPanel pnDisparos;
	private JPanel pnTablero;

	private SpaceInvaders spaceInvaders;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenu mnAyuda;
	private JMenuItem miNuevo;
	private JMenuItem miSalir;
	private JMenuItem miAcercaDe;
	private JSeparator separator;
	private JMenuItem miContenidos;
	private JSeparator separator_1;

	private ProcesaBotonTablero pB;
	private JMenu mnNivel;
	private JRadioButtonMenuItem rdbtmFacil;
	private JRadioButtonMenuItem rdbtmDificil;
	private JRadioButtonMenuItem rdbtmIntermedio;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	class ProcesaBotonTablero implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton botonPulsado = (JButton) e.getSource();
			int posicion = Integer.parseInt(botonPulsado.getActionCommand());
			dispara(posicion);
		}

	}
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(SpaceInvaders spaceInvaders) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				confirmarSalir();
			}
		});
		setForeground(Color.BLACK);
		this.spaceInvaders = spaceInvaders;
		pB = new ProcesaBotonTablero();
		inicializar(Nivel.INTERMEDIO);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/invader.jpg")));
		setTitle("Invasión Espacial");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1080, 400);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtDado());
		contentPane.add(getLbNave());
		contentPane.add(getLbTierra());
		contentPane.add(getTxtPuntos());
		contentPane.add(getTxtPuntos2());
		contentPane.add(getPnDisparos());
		contentPane.add(getPnTablero());

	}

	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton("");
			btDado.setFocusable(false);
			btDado.setToolTipText("Pulsa para obtener el numero de disparos");
			btDado.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dice.jpg")));
			btDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					iniciarSpaceInvaders();
				}
			});
			btDado.setBorder(null);
			btDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dice.jpg")));
			btDado.setBounds(22, 11, 109, 113);
		}
		return btDado;
	}

	private void iniciarSpaceInvaders() {
		spaceInvaders.lanzarDado();
		pintaDisparos();
		habilitaTablero(true);
		getBtDado().setEnabled(false);
	}

	private void pintaDisparos() {
		for (int i = 0; i < spaceInvaders.getDisparos(); i++) {
			getPnDisparos().add(nuevoDisparo());
		}
		validate();
	}

	private JLabel nuevoDisparo() {
		JLabel lbDisparo = new JLabel("");
		lbDisparo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/shoot.png")));
		return lbDisparo;
	}

	private JLabel getLbNave() {
		if (lbNave == null) {
			lbNave = new JLabel("");
			lbNave.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/spaceship.png")));
			lbNave.setBounds(394, 30, 143, 84);
		}
		return lbNave;
	}

	private JLabel getLbTierra() {
		if (lbTierra == null) {
			lbTierra = new JLabel("");
			lbTierra.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/earth.jpg")));
			lbTierra.setBounds(826, 30, 211, 169);
		}
		return lbTierra;
	}

	private JTextField getTxtPuntos() {
		if (txtPuntos == null) {
			txtPuntos = new JTextField();
			txtPuntos.setBorder(null);
			txtPuntos.setFont(new Font("Consolas", Font.PLAIN, 25));
			txtPuntos.setHorizontalAlignment(SwingConstants.CENTER);
			txtPuntos.setText("1000");
			txtPuntos.setForeground(Color.GREEN);
			txtPuntos.setBackground(Color.BLACK);
			txtPuntos.setFocusable(false);
			txtPuntos.setEditable(false);
			txtPuntos.setBounds(744, 64, 72, 39);
			txtPuntos.setColumns(10);
		}
		return txtPuntos;
	}

	private JTextField getTxtPuntos2() {
		if (txtPuntos2 == null) {
			txtPuntos2 = new JTextField();
			txtPuntos2.setBorder(null);
			txtPuntos2.setText("Puntos");
			txtPuntos2.setHorizontalAlignment(SwingConstants.CENTER);
			txtPuntos2.setForeground(Color.WHITE);
			txtPuntos2.setFont(new Font("Consolas", Font.PLAIN, 17));
			txtPuntos2.setFocusable(false);
			txtPuntos2.setEditable(false);
			txtPuntos2.setColumns(10);
			txtPuntos2.setBackground(Color.BLACK);
			txtPuntos2.setBounds(744, 30, 72, 39);
		}
		return txtPuntos2;
	}

	private JPanel getPnDisparos() {
		if (pnDisparos == null) {
			pnDisparos = new JPanel();
			pnDisparos.setBackground(Color.BLACK);
			pnDisparos.setBounds(210, 136, 520, 75);
		}
		return pnDisparos;
	}

	private JPanel getPnTablero() {
		if (pnTablero == null) {
			pnTablero = new JPanel();
			pnTablero.setBorder(new LineBorder(new Color(0, 0, 255), 5));
			pnTablero.setBackground(new Color(0, 0, 255));
			pnTablero.setBounds(88, 233, 915, 95);
			pnTablero.setLayout(new GridLayout(0, 8, 8, 0));
			aniadirBotones();
		}
		return pnTablero;
	}

	private void aniadirBotones() {
		for (int i = 0; i < spaceInvaders.getDim(); i++) {
			getPnTablero().add(nuevoBoton(i));
			habilitaTablero(false);
			validate();
		}
	}

	private JButton nuevoBoton(int i) {
		JButton bt = new JButton("");
		bt.setActionCommand(String.valueOf(i));
		bt.setBackground(Color.BLACK);
		bt.addActionListener(pB);
		return bt;
	}

	private void habilitaTablero(boolean estado) {
		for (int i = 0; i < getPnTablero().getComponents().length; i++) {
			getPnTablero().getComponents()[i].setEnabled(estado);
		}
	}

	private void dispara(int i) {
		spaceInvaders.dispara(i);
		representaspaceInvaders(i);
	}

	private void representaspaceInvaders(int i) {
		pintaPuntos();
		despintaDisparo();
		pintaCasilla(i);
		compruebaFin();
		puntosA0();
		deshabilitaBoton(i);
	}

	private void puntosA0() {
		if (spaceInvaders.getPuntuacion() < 0) {
			getTxtPuntos().setText("0");
		}		
	}

	private void pintaPuntos() {
		getTxtPuntos().setText(String.valueOf(spaceInvaders.getPuntuacion()));
	}

	private void despintaDisparo() {
		getPnDisparos().remove(0);
		getPnDisparos().repaint();
	}

	private void pintaCasilla(int i) {
		ImageIcon imagen = new ImageIcon(VentanaPrincipal.class.getResource(spaceInvaders.obtenerImagen(i)));
		((JButton) getPnTablero().getComponent(i)).setIcon(imagen);
		((JButton) getPnTablero().getComponent(i)).setDisabledIcon(imagen); // para que no salga en gris
	}

	private void compruebaFin() {
		if (spaceInvaders.isFinJuego()) {
			habilitaTablero(false);
			tipoFin();
			destaparTablero();
		}
	}

	private void tipoFin() {
		if (spaceInvaders.getCasillaDisparada() == spaceInvaders.getCasillaInvasor()) {
			JOptionPane.showMessageDialog(null, "Partida finalizada\nInvasor eliminado", "Invasion espacial",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (spaceInvaders.getCasillaDisparada() == spaceInvaders.getCasillaMeteorito()) {
			JOptionPane.showMessageDialog(null, "Partida finalizada\nChoque con meteorito", "Invasion espacial",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Partida finalizada\nTe has quedado sin disparos", "Invasion espacial",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void destaparTablero() {
		for (int i = 0; i < getPnTablero().getComponentCount(); i++) {
			pintaCasilla(i);
		}
	}

	private void deshabilitaBoton(int i) {
		((JButton) getPnTablero().getComponent(i)).setEnabled(false);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBorder(null);
			menuBar.setBackground(Color.BLACK);
			menuBar.setForeground(Color.WHITE);
			menuBar.add(getMnJuego());
			menuBar.add(getMnNivel());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}

	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("Juego");
			mnJuego.setMnemonic('j');
			mnJuego.add(getMiNuevo());
			mnJuego.add(getSeparator());
			mnJuego.add(getMiSalir());
		}
		return mnJuego;
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
			miNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			miNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar(spaceInvaders.getNivel());
				}
			});
			miNuevo.setMnemonic('u');
		}
		return miNuevo;
	}

	private void inicializar(Nivel nivel) {
		spaceInvaders.inicializar(nivel);
		getTxtPuntos().setText("1000");
		getPnDisparos().removeAll();
		getPnDisparos().repaint();
		for (int i = 0; i < getPnTablero().getComponentCount(); i++) {
			despintarCasilla(i);
		}
		getBtDado().setEnabled(true);
		habilitaTablero(false);
		redimensionarTablero(nivel);
	}

	private void redimensionarTablero(Nivel nivel) {
		int ancho = 0;
		int x = 0;
		switch (nivel) {
		case FACIL: {
			x = 20;
			ancho = 1010;
			break;
		}
		case INTERMEDIO: {
			x = 120;
			ancho = 815;
			break;
		}
		case DIFICIL: {
			x = 190;
			ancho = 610;
			break;
		}
		}
		getPnTablero().setBounds(x, 210, ancho, 105);
		getPnTablero().setLayout(new GridLayout(1, spaceInvaders.getDim(), 4, 0)); // filas, columnas, hgap, vgap
		getPnTablero().removeAll();
		// Se añaden los botones al tablero
		aniadirBotones();
	}

	private void despintarCasilla(int i) {
		((JButton) getPnTablero().getComponent(i)).setIcon(null);
		((JButton) getPnTablero().getComponent(i)).setDisabledIcon(null);
	}

	private JMenuItem getMiSalir() {
		if (miSalir == null) {
			miSalir = new JMenuItem("Salir");
			miSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
			miSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					confirmarSalir();
				}
			});
			miSalir.setMnemonic('a');
		}
		return miSalir;
	}

	private void confirmarSalir() {
		if (JOptionPane.showConfirmDialog(this,
				"¿Estás seguro que quieres salir de la aplicación?") == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	private JMenuItem getMiAcercaDe() {
		if (miAcercaDe == null) {
			miAcercaDe = new JMenuItem("Acerca de");
			miAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
			miAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"Juego SpaceInvaders \nRealizado por Yaiza Vega \n" + "Practicas CPM 25-26 \nEII Oviedo",
							"Acerca de", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			miAcercaDe.setMnemonic('e');
		}
		return miAcercaDe;
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
			miContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		}
		return miContenidos;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}



	private JMenu getMnNivel() {
		if (mnNivel == null) {
			mnNivel = new JMenu("Nivel");
			mnNivel.add(getRdbtmFacil());
			mnNivel.add(getRdbtmIntermedio());
			mnNivel.add(getRdbtmDificil());
		}
		return mnNivel;
	}

	private JRadioButtonMenuItem getRdbtmFacil() {
		if (rdbtmFacil == null) {
			rdbtmFacil = new JRadioButtonMenuItem("Facil");
			rdbtmFacil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar(Nivel.FACIL);
				}
			});
			buttonGroup.add(rdbtmFacil);
		}
		return rdbtmFacil;
	}

	private JRadioButtonMenuItem getRdbtmDificil() {
		if (rdbtmDificil == null) {
			rdbtmDificil = new JRadioButtonMenuItem("Dificil");
			rdbtmDificil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar(Nivel.DIFICIL);
				}
			});
			buttonGroup.add(rdbtmDificil);
		}
		return rdbtmDificil;
	}

	private JRadioButtonMenuItem getRdbtmIntermedio() {
		if (rdbtmIntermedio == null) {
			rdbtmIntermedio = new JRadioButtonMenuItem("Intermedio");
			rdbtmIntermedio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar(Nivel.INTERMEDIO);
				}
			});
			buttonGroup.add(rdbtmIntermedio);
			rdbtmIntermedio.setSelected(true);
		}
		return rdbtmIntermedio;
	}
}
