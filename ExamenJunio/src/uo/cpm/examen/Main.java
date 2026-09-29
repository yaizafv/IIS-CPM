package uo.cpm.examen;

import java.awt.EventQueue;

import uo.cpm.examen.service.Service;
import uo.cpm.examen.ui.*;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Service sv = new Service();
				try {
					VentanaPrincipal frame = new VentanaPrincipal(sv);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
