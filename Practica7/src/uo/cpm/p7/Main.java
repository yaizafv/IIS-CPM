package uo.cpm.p7;

import java.awt.EventQueue;

import uo.cpm.p7.service.SpaceInvaders;
import uo.cpm.p7.ui.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		SpaceInvaders spaceInvaders = new SpaceInvaders();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*
					 * Properties props = new Properties(); props.put("logoString", "");
					 * HiFiLookAndFeel.setCurrentTheme(props);
					 * UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					 */
					VentanaPrincipal frame = new VentanaPrincipal(spaceInvaders);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
