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

import uo.cpm.p7.service.SpaceInvaders;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

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
	private JButton bt0;
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
	private JButton bt5;
	private JButton bt6;
	private JButton bt7;

	private SpaceInvaders spaceInvaders;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenu mnAyuda;
	private JMenuItem miNuevo;
	private JMenuItem miSalir;
	private JMenuItem miAcercaDe;
	private JSeparator separator;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(SpaceInvaders spaceInvaders) {
		this.spaceInvaders = spaceInvaders;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/invader.jpg")));
		setTitle("Invasión Espacial");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 407);
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
			lbNave.setBounds(308, 30, 143, 84);
		}
		return lbNave;
	}

	private JLabel getLbTierra() {
		if (lbTierra == null) {
			lbTierra = new JLabel("");
			lbTierra.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/earth.jpg")));
			lbTierra.setBounds(712, 30, 211, 169);
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
			txtPuntos.setBounds(590, 57, 72, 39);
			txtPuntos.setColumns(10);
		}
		return txtPuntos;
	}

	private void puntosA0() {
		if (spaceInvaders.getPuntuacion() < 0) {
			getTxtPuntos().setText("0");
		}
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
			txtPuntos2.setBounds(590, 30, 72, 39);
		}
		return txtPuntos2;
	}

	private JPanel getPnDisparos() {
		if (pnDisparos == null) {
			pnDisparos = new JPanel();
			pnDisparos.setBackground(Color.BLACK);
			pnDisparos.setBounds(205, 136, 340, 75);
		}
		return pnDisparos;
	}

	private JPanel getPnTablero() {
		if (pnTablero == null) {
			pnTablero = new JPanel();
			pnTablero.setBorder(new LineBorder(new Color(0, 0, 255), 5));
			pnTablero.setBackground(new Color(0, 0, 255));
			pnTablero.setBounds(22, 248, 915, 95);
			pnTablero.setLayout(new GridLayout(0, 8, 8, 0));
			pnTablero.add(getBt0());
			pnTablero.add(getBt1());
			pnTablero.add(getBt2());
			pnTablero.add(getBt3());
			pnTablero.add(getBt4());
			pnTablero.add(getBt5());
			pnTablero.add(getBt6());
			pnTablero.add(getBt7());
			habilitaTablero(false);
		}
		return pnTablero;
	}

	private JButton getBt0() {
		if (bt0 == null) {
			bt0 = new JButton("");
			bt0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(0);
				}
			});
			bt0.setBorder(null);
			bt0.setBackground(new Color(0, 0, 0));
		}
		return bt0;
	}

	private void habilitaTablero(boolean estado) {
		for (int i = 0; i < getPnTablero().getComponents().length; i++) {
			getPnTablero().getComponents()[i].setEnabled(estado);
		}
	}

	private JButton getBt1() {
		if (bt1 == null) {
			bt1 = new JButton("");
			bt1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(1);
				}
			});
			bt1.setBorder(null);
			bt1.setBackground(new Color(0, 0, 0));
		}
		return bt1;
	}

	private JButton getBt2() {
		if (bt2 == null) {
			bt2 = new JButton("");
			bt2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(2);
				}
			});
			bt2.setBorder(null);
			bt2.setBackground(new Color(0, 0, 0));
		}
		return bt2;
	}

	private JButton getBt3() {
		if (bt3 == null) {
			bt3 = new JButton("");
			bt3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(3);
				}
			});
			bt3.setBorder(null);
			bt3.setBackground(new Color(0, 0, 0));
		}
		return bt3;
	}

	private JButton getBt4() {
		if (bt4 == null) {
			bt4 = new JButton("");
			bt4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(4);
				}
			});
			bt4.setBorder(null);
			bt4.setBackground(new Color(0, 0, 0));
		}
		return bt4;
	}

	private JButton getBt5() {
		if (bt5 == null) {
			bt5 = new JButton("");
			bt5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(5);
				}
			});
			bt5.setBorder(null);
			bt5.setBackground(new Color(0, 0, 0));
		}
		return bt5;
	}

	private JButton getBt6() {
		if (bt6 == null) {
			bt6 = new JButton("");
			bt6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(6);
				}
			});
			bt6.setBorder(null);
			bt6.setBackground(new Color(0, 0, 0));
		}
		return bt6;
	}

	private JButton getBt7() {
		if (bt7 == null) {
			bt7 = new JButton("");
			bt7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(7);
				}

			});
			bt7.setBorder(null);
			bt7.setBackground(new Color(0, 0, 0));
		}
		return bt7;
	}

	private void dispara(int i) {
		spaceInvaders.dispara(i);
		representaspaceInvaders(i);
	}

	private void representaspaceInvaders(int i) {
		pintaPuntos();
		despintaDisparo();
		pintaCasilla(i);
		puntosA0();
		compruebaFin();
		deshabilitaBoton(i);
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
		for (int i = 0; i < spaceInvaders.getTablero().getCasillas().length; i++) {
			pintaCasilla(i);
		}
	}

	private void deshabilitaBoton(int i) {
		((JButton) getPnTablero().getComponent(i)).setEnabled(false);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnJuego());
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
			miNuevo.setMnemonic('u');
		}
		return miNuevo;
	}
	
	private void inicializar() {
		spaceInvaders.inicializar();
		getTxtPuntos().setText("1000");
		getPnDisparos().removeAll();
		getPnDisparos().repaint();
		for (int i = 0; i < getPnTablero().getComponentCount(); i++) {
	        despintarCasilla(i);
	    }
	    getBtDado().setEnabled(true);
	}
	
	private void despintarCasilla(int i) {
		((JButton) getPnTablero().getComponent(i)).setIcon(null);
		((JButton) getPnTablero().getComponent(i)).setDisabledIcon(null); 
	}
	

	private JMenuItem getMiSalir() {
		if (miSalir == null) {
			miSalir = new JMenuItem("Salir");
			miSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(EXIT_ON_CLOSE);
				}
			});
			miSalir.setMnemonic('a');
		}
		return miSalir;
	}

	private JMenuItem getMiAcercaDe() {
		if (miAcercaDe == null) {
			miAcercaDe = new JMenuItem("Acerca de");
			miAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"Juego SpaceInvaders \nRealizado por Yaiza Vega \n"
									+ "Practicas CPM 25-26 \nEII Oviedo",
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
}
