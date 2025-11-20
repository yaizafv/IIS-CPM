package uo.cpm.p10.player;

import java.io.File;

public class Song {			//o extends file
	private File file;

	public Song(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public String toString() {
		return file.getName();
	}
}
