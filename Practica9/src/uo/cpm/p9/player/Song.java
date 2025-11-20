package uo.cpm.p9.player;

import java.io.File;

public class Song {
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
