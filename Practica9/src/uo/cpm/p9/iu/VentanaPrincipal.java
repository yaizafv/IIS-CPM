package uo.cpm.p9.iu;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import uo.cpm.p9.player.MusicPlayer;
import uo.cpm.p9.player.Song;

import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Insets;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMusic;
	private JMenu mnOptions;
	private JMenu mnHelp;
	private JPanel pnNorte;
	private JLabel lbLogo;
	private JSlider slVolumen;
	private JPanel pnVol;
	private JLabel lbVolumen;
	private JLabel lbVolumen2;
	private JPanel pnCentro;
	private JPanel pnLibrary;
	private JPanel pnPlay;
	private JLabel lbLibrary;
	private JLabel lbPlaylist;
	private JPanel pnBtLibrary;
	private JButton btAdd;
	private JButton btDel;
	private JScrollPane scListLibrary;
	private JList<Song> listLibrary;
	private JPanel pnBtPlay;
	private JButton btRew;
	private JButton btPlay;
	private JButton btStop;
	private JButton btFow;
	private JButton btDel2;
	private JScrollPane scListPlay;
	private JList<Song> listPlay;
	private JMenuItem mniOpen;
	private JMenuItem mniExit;
	private JSeparator separator;
	private JMenuItem mniContents;
	private JMenuItem mniAbout;
	private JSeparator separator_1;

	private JFileChooser selector;
	private MusicPlayer mP;
	private DefaultListModel<Song> modeloListLibrary;
	private DefaultListModel<Song> modeloListPlay;
	private JButton btClear;
	private JButton btClear2;
	private JMenuItem mniRandom;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(MusicPlayer mp) {
		this.mP = mp;
		setMinimumSize(new Dimension(551, 235));
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				minimoVentana();
			}
		});
		setTitle("EII Music Player");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoTitulo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(675, 600);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnCentro(), BorderLayout.CENTER);

	}

	private void minimoVentana() {
		System.out.println(this.getSize());
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnMusic());
			menuBar.add(getMnOptions());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnMusic() {
		if (mnMusic == null) {
			mnMusic = new JMenu("Music");
			mnMusic.setMnemonic('m');
			mnMusic.add(getMniOpen());
			mnMusic.add(getSeparator());
			mnMusic.add(getMniExit());
		}
		return mnMusic;
	}

	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
			mnOptions.setMnemonic('p');
			mnOptions.add(getMniRandom());
		}
		return mnOptions;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('e');
			mnHelp.add(getMniContents());
			mnHelp.add(getSeparator_1());
			mnHelp.add(getMniAbout());
		}
		return mnHelp;
	}

	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setBackground(Color.BLACK);
			pnNorte.setLayout(new GridLayout(1, 3, 0, 0));
			pnNorte.add(getLbLogo());
			pnNorte.add(getSlVolumen());
			pnNorte.add(getPnVol());
		}
		return pnNorte;
	}

	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
		}
		return lbLogo;
	}

	private JSlider getSlVolumen() {
		if (slVolumen == null) {
			slVolumen = new JSlider();
			slVolumen.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					pintaYCambiaVol();
				}
			});
			slVolumen.setForeground(Color.WHITE);
			slVolumen.setPaintLabels(true);
			slVolumen.setPaintTicks(true);
			slVolumen.setMinorTickSpacing(5);
			slVolumen.setMajorTickSpacing(20);
			slVolumen.setFont(new Font("Dialog", Font.BOLD, 14));
			slVolumen.setBackground(Color.BLACK);
		}
		return slVolumen;
	}

	private void pintaYCambiaVol() {
		mP.setVolume(getSlVolumen().getValue());
		getLbVolumen2().setText(String.valueOf(getSlVolumen().getValue()));
	}

	private JPanel getPnVol() {
		if (pnVol == null) {
			pnVol = new JPanel();
			pnVol.setBackground(Color.BLACK);
			pnVol.add(getLbVolumen());
			pnVol.add(getLbVolumen2());
		}
		return pnVol;
	}

	private JLabel getLbVolumen() {
		if (lbVolumen == null) {
			lbVolumen = new JLabel("Vol:");
			lbVolumen.setFont(new Font("Dialog", Font.BOLD, 32));
			lbVolumen.setForeground(Color.CYAN);
			lbVolumen.setBackground(Color.BLACK);
		}
		return lbVolumen;
	}

	private JLabel getLbVolumen2() {
		if (lbVolumen2 == null) {
			lbVolumen2 = new JLabel("50");
			lbVolumen2.setHorizontalAlignment(SwingConstants.CENTER);
			lbVolumen2.setFont(new Font("Dialog", Font.BOLD, 40));
			lbVolumen2.setForeground(Color.WHITE);
		}
		return lbVolumen2;
	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.BLACK);
			pnCentro.setLayout(new GridLayout(1, 2, 5, 0));
			pnCentro.add(getPnLibrary());
			pnCentro.add(getPnPlay());
		}
		return pnCentro;
	}

	private JPanel getPnLibrary() {
		if (pnLibrary == null) {
			pnLibrary = new JPanel();
			pnLibrary.setBorder(null);
			pnLibrary.setBackground(Color.BLACK);
			pnLibrary.setLayout(new BorderLayout(0, 0));
			pnLibrary.add(getLbLibrary(), BorderLayout.NORTH);
			pnLibrary.add(getPnBtLibrary(), BorderLayout.SOUTH);
			pnLibrary.add(getScListLibrary(), BorderLayout.CENTER);
		}
		return pnLibrary;
	}

	private JPanel getPnPlay() {
		if (pnPlay == null) {
			pnPlay = new JPanel();
			pnPlay.setBorder(null);
			pnPlay.setBackground(Color.BLACK);
			pnPlay.setLayout(new BorderLayout(0, 0));
			pnPlay.add(getLbPlaylist(), BorderLayout.NORTH);
			pnPlay.add(getPnBtPlay(), BorderLayout.SOUTH);
			pnPlay.add(getScListPlay(), BorderLayout.CENTER);
		}
		return pnPlay;
	}

	private JLabel getLbLibrary() {
		if (lbLibrary == null) {
			lbLibrary = new JLabel("♪ Library:");
			lbLibrary.setForeground(Color.MAGENTA);
			lbLibrary.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return lbLibrary;
	}

	private JLabel getLbPlaylist() {
		if (lbPlaylist == null) {
			lbPlaylist = new JLabel("♪ PlayList:");
			lbPlaylist.setForeground(Color.MAGENTA);
			lbPlaylist.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return lbPlaylist;
	}

	private JPanel getPnBtLibrary() {
		if (pnBtLibrary == null) {
			pnBtLibrary = new JPanel();
			pnBtLibrary.setLayout(new GridLayout(0, 3, 2, 0));
			pnBtLibrary.add(getBtAdd());
			pnBtLibrary.add(getBtDel());
			pnBtLibrary.add(getBtClear());
		}
		return pnBtLibrary;
	}

	private JButton getBtAdd() {
		if (btAdd == null) {
			btAdd = new JButton("Add to PlayList");
			btAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToPlayList();
				}
			});
			btAdd.setToolTipText("");
			btAdd.setMargin(new Insets(0, 0, 0, 0));
			btAdd.setFocusable(false);
			btAdd.setBackground(Color.WHITE);
			btAdd.setForeground(Color.BLACK);
			btAdd.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btAdd;
	}

	private void addToPlayList() {
		List<File> files = new ArrayList<>();
		for (Song song : getListLibrary().getSelectedValuesList()) {
			files.add(song.getFile());
		}

		mP.addListPlay(files);

		modeloListPlay.clear();
		for (File f : mP.getListPlay()) {
			modeloListPlay.addElement(new Song(f));
		}

		listPlay.setSelectedValue(new Song(mP.getCurrentSong()), true);
		getListPlay().requestFocus();
	}

	private JButton getBtDel() {
		if (btDel == null) {
			btDel = new JButton("Del");
			btDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrarDeListLibrary();
				}
			});
			btDel.setToolTipText("Delete");
			btDel.setMargin(new Insets(0, 0, 0, 0));
			btDel.setFocusable(false);
			btDel.setForeground(Color.BLACK);
			btDel.setBackground(Color.WHITE);
			btDel.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btDel;
	}

	private void borrarDeListLibrary() {
		List<Song> items = getListLibrary().getSelectedValuesList();
		if (items.isEmpty())
			return;

		List<File> reales = new ArrayList<>();
		for (Song s : items) {
			reales.add(s.getFile());
		}

		mP.deleteListLibrary(reales);

		modeloListLibrary.clear();
		for (File f : mP.getListLibrary()) {
			modeloListLibrary.addElement(new Song(f));
		}
	}

	private JScrollPane getScListLibrary() {
		if (scListLibrary == null) {
			scListLibrary = new JScrollPane();
			scListLibrary.setBorder(new LineBorder(Color.CYAN, 5));
			scListLibrary.setViewportView(getListLibrary());
		}
		return scListLibrary;
	}

	private JList<Song> getListLibrary() {
		if (listLibrary == null) {
			modeloListLibrary = new DefaultListModel<Song>();
			listLibrary = new JList<Song>(modeloListLibrary);
			listLibrary.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					seleccion();
				}
			});
			listLibrary.setFont(new Font("Tahoma", Font.PLAIN, 14));
			listLibrary.setForeground(Color.WHITE);
			listLibrary.setBackground(Color.BLACK);
		}
		return listLibrary;
	}
	
	private void seleccion() {
		Song selected = getListLibrary().getSelectedValue();
        if (selected != null) {
            mP.setCurrentSong(selected.getFile());
        }
	}

	private JPanel getPnBtPlay() {
		if (pnBtPlay == null) {
			pnBtPlay = new JPanel();
			pnBtPlay.setLayout(new GridLayout(0, 6, 2, 0));
			pnBtPlay.add(getBtRew());
			pnBtPlay.add(getBtPlay());
			pnBtPlay.add(getBtStop());
			pnBtPlay.add(getBtFow());
			pnBtPlay.add(getBtDel2());
			pnBtPlay.add(getBtClear2());
		}
		return pnBtPlay;
	}

	private JButton getBtRew() {
		if (btRew == null) {
			btRew = new JButton("\u25C4\u25C4"); // ◄◄
			btRew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rewind();
				}
			});
			btRew.setToolTipText("Rewind");
			btRew.setFocusable(false);
			btRew.setMargin(new Insets(0, 0, 0, 0));
			btRew.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btRew;
	}

	private void rewind() {
		mP.rewind();
		getListPlay().setSelectedValue(mP.getCurrentSong(), true);
	}

	private JButton getBtPlay() {
		if (btPlay == null) {
			btPlay = new JButton("\u25BA"); // ►
			btPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mP.play();
				}
			});
			btPlay.setToolTipText("Play");
			btPlay.setFocusable(false);
			btPlay.setMargin(new Insets(0, 0, 0, 0));
			btPlay.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btPlay;
	}

	private JButton getBtStop() {
		if (btStop == null) {
			btStop = new JButton("\u25A0"); // ■
			btStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mP.stop();
				}
			});
			btStop.setToolTipText("Stop");
			btStop.setFocusable(false);
			btStop.setMargin(new Insets(0, 0, 0, 0));
			btStop.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btStop;
	}

	private JButton getBtFow() {
		if (btFow == null) {
			btFow = new JButton("\u25BA\u25BA"); // ►►
			btFow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					forward();
				}
			});
			btFow.setToolTipText("Forward");
			btFow.setFocusable(false);
			btFow.setMargin(new Insets(0, 0, 0, 0));
			btFow.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btFow;
	}

	private void forward() {
		mP.forward();
		getListPlay().setSelectedValue(mP.getCurrentSong(), true);
	}

	private JButton getBtDel2() {
		if (btDel2 == null) {
			btDel2 = new JButton("Del");
			btDel2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrarDePlayList();
				}
			});
			btDel2.setToolTipText("Delete");
			btDel2.setFocusable(false);
			btDel2.setMargin(new Insets(0, 0, 0, 0));
			btDel2.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btDel2;
	}

	private void borrarDePlayList() {
		mP.deleteListPlay(getListPlay().getSelectedValue().getFile());
		modeloListPlay.removeElement(getListPlay().getSelectedValue());
	}

	private JScrollPane getScListPlay() {
		if (scListPlay == null) {
			scListPlay = new JScrollPane();
			scListPlay.setBorder(new LineBorder(Color.CYAN, 5));
			scListPlay.setViewportView(getListPlay());
		}
		return scListPlay;
	}

	private JList<Song> getListPlay() {
		if (listPlay == null) {
			modeloListPlay = new DefaultListModel<Song>();
			listPlay = new JList<Song>(modeloListPlay);
			listPlay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listPlay.setForeground(Color.WHITE);
			listPlay.setFont(new Font("Tahoma", Font.PLAIN, 14));
			listPlay.setBackground(Color.BLACK);
		}
		return listPlay;
	}

	private JMenuItem getMniOpen() {
		if (mniOpen == null) {
			mniOpen = new JMenuItem("Open...");
			mniOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarMusica();
				}
			});
			mniOpen.setMnemonic('o');
			mniOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		}
		return mniOpen;
	}

	private void cargarMusica() {
		if (getSelector().showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			mP.addListLibrary(getSelector().getSelectedFiles());
			modeloListLibrary.clear();
			for (File f : mP.getListLibrary()) {
				modeloListLibrary.addElement(new Song(f));
			}
		}
	}

	private JMenuItem getMniExit() {
		if (mniExit == null) {
			mniExit = new JMenuItem("Exit");
			mniExit.setMnemonic('e');
		}
		return mniExit;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private JMenuItem getMniContents() {
		if (mniContents == null) {
			mniContents = new JMenuItem("Contents");
			mniContents.setMnemonic('c');
			mniContents.setEnabled(false);
		}
		return mniContents;
	}

	private JMenuItem getMniAbout() {
		if (mniAbout == null) {
			mniAbout = new JMenuItem("About");
			mniAbout.setMnemonic('a');
		}
		return mniAbout;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}

	private JFileChooser getSelector() {
		if (selector == null) { // si no existe, lo creamos
			selector = new JFileChooser();
			selector.setMultiSelectionEnabled(true);
			// Establecer un filtro
			selector.setFileFilter(new FileNameExtensionFilter("Archivos mp3", "mp3"));
			// Cambiar el directorio por defecto al de ejecucion del programa
			String curDir = System.getProperty("user.dir");
			selector.setCurrentDirectory(new File(curDir));
			// Con esta otra lo fija en el escritorio
			// String desktopPath = System.getProperty("user.home") + "/Escritorio";
			// selector.setCurrentDirectory(new File(desktopPath));
		}
		return selector;
	}

	private JButton getBtClear() {
		if (btClear == null) {
			btClear = new JButton("Clear");
			btClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearListLibrary();
				}
			});
			btClear.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btClear;
	}

	private void clearListLibrary() {
		mP.clearListLibrary();
		modeloListLibrary.removeAllElements();
	}

	private JButton getBtClear2() {
		if (btClear2 == null) {
			btClear2 = new JButton("Clear");
			btClear2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearListPlay();
				}
			});
			btClear2.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btClear2;
	}
	
	private void clearListPlay() {
		mP.clearListPlay();
		modeloListPlay.removeAllElements();
	}
	private JMenuItem getMniRandom() {
		if (mniRandom == null) {
			mniRandom = new JMenuItem("Random");
			mniRandom.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					random();
				}
			});
			mniRandom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		}
		return mniRandom;
	}
	
	private void random() {
		getListPlay().setSelectedIndex(mP.random());
	}
}
