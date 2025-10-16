package uo.cpm.p5;

import java.awt.EventQueue;

import uo.cpm.p5.model.Operaciones;
import uo.cpm.p5.ui.VentanaPrincipal;

public class Main {
	
	public static void main(String[] args) {
		Operaciones op = new Operaciones();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(op);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
