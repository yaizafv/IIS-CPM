package uo.cpm.mcd.ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.LineBorder;

import uo.cpm.mcd.model.*;

public class PanelImagenBoton extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lbTipo;
	private JLabel lblImagen;
	private JPanel panel;
	private JButton btAniadir;
	private VentanaPrincipal vP;
	private Articulo articulo;
	private JLabel lbDenominacion;
	private JLabel lblPrecio;
	private JSpinner spinner;

	public PanelImagenBoton(VentanaPrincipal vP, Articulo a)  {
		this.vP = vP;
		this.articulo = a;
		setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		setBackground(Color.white);
		setLayout(new GridLayout(1,5,0,0));
		add(getLbTipo());
		add(getLblImagen());
		add(getLbDenominacion());
		add(getLblPrecio());
		add(getPanel());
	}

	private JLabel getLbTipo() {
		if (lbTipo == null) {
			lbTipo = new JLabel();
			lbTipo.setBackground(Color.WHITE);
			lbTipo.setText("  " + articulo.getTipo());	
		}
		return lbTipo;
	}
	
	private JLabel getLblImagen() {
		if (lblImagen == null) {
			lblImagen = new JLabel("");
			lblImagen.setBackground(Color.WHITE);
			adaptarImagenLabel();
		}
		return lblImagen;
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
			panel.add(getSpinner());
			panel.add(getBtAniadir());
		}
		return panel;
	}
	
	private JButton getBtAniadir() {
		if (btAniadir == null) {
			btAniadir = new JButton("Añadir");
			btAniadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aniadirAPedido(articulo);
				}
			});
		}
		return btAniadir;
	}
	
	private void aniadirAPedido(Articulo a) {
		if ((Integer) (getSpinner().getValue()) >= 1) {
			vP.aniadirAPedido(a);
			vP.getMcDonalds().toString();
		} 
	}
	
	private JLabel getLbDenominacion() {
		if (lbDenominacion == null) {
			lbDenominacion = new JLabel();
			lbDenominacion.setText(articulo.getDenominacion());
		}
		return lbDenominacion;
	}
	
	private JLabel getLblPrecio() {
		if (lblPrecio == null) {
			lblPrecio = new JLabel();
			lblPrecio.setFont(new Font("Arial Black", Font.BOLD, 14));
			lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrecio.setText(String.valueOf(articulo.getPrecio()));
		}
		return lblPrecio;
	}
	
	private void adaptarImagenLabel(){
		  Image imgOriginal = (new ImageIcon (PanelImagenBoton.class.getResource("/img/"+articulo.getCodigo()+".png"))).getImage();
		  Image imgEscalada = imgOriginal.getScaledInstance(90,90,Image.SCALE_SMOOTH);
		  getLblImagen().setIcon(new ImageIcon(imgEscalada));
	}
	
	
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setMinimumSize(new Dimension(50, 25));
		}
		return spinner;
	}
}
