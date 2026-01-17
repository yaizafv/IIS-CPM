package uo.cpm.p12;

import java.awt.EventQueue;

import javax.swing.UIManager;

import uo.cpm.p12.service.*;
import uo.cpm.p12.ui.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		final McDonalds mc = new McDonalds();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal(mc);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}