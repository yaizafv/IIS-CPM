package uo.cpm.p9;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import uo.cpm.p9.iu.VentanaPrincipal;
import uo.cpm.p9.player.MusicPlayer;

public class Main {
	public static void main(String[] args) {
		MusicPlayer mP = new MusicPlayer();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		      try {
		    	  Properties props = new Properties();
		    	  props.put("logoString", "");
		    	  props.put("focusColor", "0 0 0");  // Para que no se vea el foco amarillo en el slider
		    	  HiFiLookAndFeel.setCurrentTheme(props); 
		    	  UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		    	  VentanaPrincipal v = new VentanaPrincipal(mP);
		    	  v.setVisible(true);
		      } catch (Exception e) {
		    	  JOptionPane.showMessageDialog(null, "Error: "+e);
		      }
		    }
		  });

	}

}