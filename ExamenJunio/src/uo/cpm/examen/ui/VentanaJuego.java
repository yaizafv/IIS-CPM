package uo.cpm.examen.ui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class VentanaJuego extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private VentanaPeliculas vPel;
	private JPanel panel;

	private DestaparCasilla dc;
	private JLabel lbSelecciona;
	
	class DestaparCasilla extends MouseAdapter {

		private int getIndexJb(JButton jb) {
			for (int i = 0; i < getPanel().getComponents().length; i++) {
				JButton jb2 = (JButton) getPanel().getComponent(i);
				if (jb.equals(jb2)) {
					return i;
				}
			}
			return 0;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			JButton jb = (JButton) e.getSource();
			pintarTablero();
			resultado(getIndexJb(jb));
		}	

	}

	public VentanaJuego(VentanaPeliculas vPel) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaJuego.class.getResource("/img/logo.jpg")));
		setTitle("Cine: Juego");
		this.vPel = vPel;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 528, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLbSelecciona());
		dc = new DestaparCasilla();
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(71, 76, 354, 82);
			panel.setLayout(new GridLayout(0, 4, 4, 0));
			for (int i = 0; i < vPel.getVp().getSv().getNumCasillas(); i++) {
				panel.add(aniadirBoton(i));
			}
		}
		return panel;
	}

	private JButton aniadirBoton(int i) {
		JButton jb = new JButton(String.valueOf(i + 1));
		jb.addMouseListener(dc);
		return jb;
	}

	private void pintarTablero() {
		for (int i = 0; i < getPanel().getComponents().length; i++) {
			JButton jb = (JButton) getPanel().getComponent(i);
			if (i == vPel.getVp().getSv().getIndexCasillaPremio()) {
				jb.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/premio.PNG")));
			} else {
				jb.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/nopremio.PNG")));
			}
		}
	}

	private void resultado(int i) {
		if (i == vPel.getVp().getSv().getIndexCasillaPremio()) {
			JOptionPane.showMessageDialog(this, "Has conseguido el premio");
		} else {
			JOptionPane.showMessageDialog(this, "No has conseguido el premio. Intentelo en otra ocasion :(");
		}
		vPel.inicializar();
	}


	private JLabel getLbSelecciona() {
		if (lbSelecciona == null) {
			lbSelecciona = new JLabel("Selecciona una casilla para saber si has obtenido premio!");
			lbSelecciona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbSelecciona.setBounds(71, 42, 361, 23);
		}
		return lbSelecciona;
	}

}
