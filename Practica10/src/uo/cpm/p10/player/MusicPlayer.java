package uo.cpm.p10.player;

import java.io.File;
import java.util.*;

import javazoom.jlgui.basicplayer.*;

public class MusicPlayer {
	public static final double VOLUME_MAX = 100;
	public static final double VOLUME_MIN = 0;

	private BasicPlayer basicPlayer = null;
	private List<File> listLibrary = null;
	private List<File> listPlay = null;
	private File currentSong; // representa la cancion que está seleccionada en el ListPlay
	private int volume = 0; // representa el volumen actual

	public MusicPlayer() {
		basicPlayer = new BasicPlayer();
		listLibrary = new ArrayList<File>();
		listPlay = new ArrayList<File>();
		currentSong = null;
		volume = 50;
	}

	public List<File> getListLibrary() {
		return listLibrary;
	}

	public List<File> getListPlay() {
		return listPlay;
	}

	public File getCurrentSong() {
		return currentSong;
	}

	public void setCurrentSong(File f) {
		this.currentSong = f;
	}

	public int getVolume() {
		return volume;
	}

	public void addListLibrary(File[] selectedFiles) {
		listLibrary.addAll(Arrays.asList(selectedFiles));
	}

	public void addListPlay(List<File> selectedValuesList) {
		// Opcion 1: Permitiendo canciones repetidas en el listPlay
		// listPlay.addAll(selectedValuesList);

		// Opcion 2: si la cancion no esta ya en el listPlay, la añadimos
		for (int i = 0; i < selectedValuesList.size(); i++) {
			if (!listPlay.contains(selectedValuesList.get(i))) {
				listPlay.add(selectedValuesList.get(i));
			}
		}

		if (currentSong == null) {
			currentSong = listPlay.get(0); // si no hay ninguna seleccionada, seleccionamos la primera
		}

	}

	public void deleteListLibrary(List<File> selectedValuesList) {
		listLibrary.removeAll(selectedValuesList);
	}

	public void rewind() {
		int position = listPlay.indexOf(currentSong);
		if (position != 0) {
			currentSong = listPlay.get(position - 1);
		} else {
			currentSong = listPlay.get(listPlay.size() - 1);
		}
		play();
	}

	public void forward() {
		int position = listPlay.indexOf(currentSong);
		if (position != listPlay.size() - 1) {
			currentSong = listPlay.get(position + 1);
		} else {
			currentSong = listPlay.get(0);
		}
		play();
	}

	public int searchFilePosition() {
		if (currentSong == null) {
	        return -1;
	    }
	    return listPlay.indexOf(currentSong);
	}

	public void deleteListPlay(File selectedValue) {
		boolean wasCurrent = selectedValue.equals(currentSong);
		int pos = listPlay.indexOf(selectedValue);

		listPlay.remove(selectedValue);

		if (listPlay.isEmpty()) {
			currentSong = null;
			stop();
		}

		if (wasCurrent) {
			// elegir la siguiente si existe, si no la anterior
			if (pos < listPlay.size()) {
				currentSong = listPlay.get(pos);
			} else {
				currentSong = listPlay.get(listPlay.size() - 1);
			}
			play();
		}
	}

	public void clearListLibrary() {
		listLibrary.removeAll(listLibrary);
	}

	public void clearListPlay() {
		listPlay.removeAll(listPlay);
	}
	
	public int random() {
		Random rnd = new Random();
		int indice = rnd.nextInt(listPlay.size());
		currentSong = listPlay.get(indice);
		play();
		
		return indice;
	}

	/**********************************************
	 * REPRODUCTOR *
	 **********************************************/

	public void play() {
		try {
			basicPlayer.open(currentSong);
			basicPlayer.play();
			setVolume(volume);
		} catch (BasicPlayerException e) {
			System.out.println("Error en play");
		}
	}

	public void stop() {
		try {
			basicPlayer.stop();
		} catch (BasicPlayerException e) {
			System.out.println("Error en stop");
		}
	}

	public void setVolume(int vol) {
		try {
			this.volume = vol;
			if (basicPlayer.getStatus() == BasicPlayer.PLAYING)
				basicPlayer.setGain(vol / VOLUME_MAX);
		} catch (BasicPlayerException e) {
			System.out.println("Error en volumen");
		}
	}
}
